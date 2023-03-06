package it.its.nttdata.demo.jobs;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableBatchProcessing
public class PostKnifeJob {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job firstJobCreate() {
		return this.jobBuilderFactory.get("PostKnifeJob").incrementer(new RunIdIncrementer()).start(helloStep())
				.build();
	}

	@Bean
	private Step helloStep() {
		return this.stepBuilderFactory.get("HelloStep").tasklet(new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

				try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
					HttpPost httpPost = new HttpPost("http://localhost:8080/v2/knife/addKnife");
					httpPost.setHeader("Accept", "application/json");
					httpPost.setHeader("Content-type", "application/json");
					String json = "{\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
							+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"id\": 0,\r\n"
							+ "  \"name\": \"Victorinox Classic SD Swiss Army Knife\",\r\n"
							+ "  \"photoUrls\": [\"https://m.media-amazon.com/images/I/71MF2V-4yPL._AC_SX679_.jpg\"],\r\n"
							+ "  \"status\": \"available\",\r\n" + "  \"tags\": [\r\n" + "    {\r\n"
							+ "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ]\r\n" + "}";
					StringEntity stringEntity = new StringEntity(json);
					httpPost.setEntity(stringEntity);

					System.out.println("Executing request " + httpPost.getRequestLine() + java.time.Clock.systemUTC().instant());

					// Create a custom response handler
					ResponseHandler<String> responseHandler = response -> {
						int status = response.getStatusLine().getStatusCode();
						if (status >= 200 && status < 300) {
							HttpEntity entity = response.getEntity();
							return entity != null ? EntityUtils.toString(entity) : null;
						} else {
							throw new ClientProtocolException("Unexpected response status: " + status);
						}
					};
					httpclient.execute(httpPost, responseHandler);
				}
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
}
