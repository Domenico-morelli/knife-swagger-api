package it.its.nttdata.demo.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-02-02T09:30:50.975Z")

public class OrderResponse {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("knifeId")
	private Long knifeId = null;

	@JsonProperty("quantity")
	private Integer quantity = null;

	@JsonProperty("shipDate")
	private Date shipDate = null;

	/**
	 * Order Status
	 */
	public enum StatusEnum {
		PLACED("placed"),

		APPROVED("approved"),

		DELIVERED("delivered");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("complete")
	private Boolean complete = false;

	public OrderResponse id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderResponse knifeIdId(Long knifeId) {
		this.knifeId = knifeId;
		return this;
	}

	/**
	 * Get petId
	 * 
	 * @return petId
	 **/
	@ApiModelProperty(value = "")

	public Long getKnifeId() {
		return knifeId;
	}

	public void setKnifeId(Long knifeId) {
		this.knifeId = knifeId;
	}

	public OrderResponse quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Get quantity
	 * 
	 * @return quantity
	 **/
	@ApiModelProperty(value = "")

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderResponse shipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	/**
	 * Get shipDate
	 * 
	 * @return shipDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public OrderResponse status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Order Status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Order Status")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public OrderResponse complete(Boolean complete) {
		this.complete = complete;
		return this;
	}

	/**
	 * Get complete
	 * 
	 * @return complete
	 **/
	@ApiModelProperty(value = "")

	public Boolean isComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderResponse order = (OrderResponse) o;
		return Objects.equals(this.id, order.id) && Objects.equals(this.knifeId, order.knifeId)
				&& Objects.equals(this.quantity, order.quantity) && Objects.equals(this.shipDate, order.shipDate)
				&& Objects.equals(this.status, order.status) && Objects.equals(this.complete, order.complete);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, knifeId, quantity, shipDate, status, complete);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    petId: ").append(toIndentedString(knifeId)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    shipDate: ").append(toIndentedString(shipDate)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public OrderResponse(Long id, Long knifeId, Integer quantity, Date shipDate, StatusEnum status, Boolean complete) {
		super();
		this.id = id;
		this.knifeId = knifeId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
		this.complete = complete;
	}

	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}

}
