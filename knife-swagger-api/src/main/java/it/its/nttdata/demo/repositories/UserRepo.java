package it.its.nttdata.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.its.nttdata.demo.database.User;
import it.its.nttdata.demo.model.UserResponse;

public interface UserRepo extends JpaRepository<User, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM public.shopuser WHERE public.shopuser.u_username = :username ", nativeQuery = true)
	void deleteUserbyUsername(String username);

	@Query(value = "SELECT * FROM public.shopuser WHERE u_username = :username", nativeQuery = true)
	User getUserByUsername(String username);
	/*
	@Query(value = "SELECT * FROM public.shopuser WHERE u_username = :username", nativeQuery = true)
	List<UserResponse> returnAddedUsersList(List<UserResponse> userListToAdd);
*/

	@Query(value = "UPDATE public.shopuser  set u_email = :email ,\r\n"
			+ " u_name = :firstName ,\r\n"
			+ " u_password = :password ,\r\n"
			+ " u_username = :newUsername ,\r\n"
			+ " u_phone = :phone ,\r\n"
			+ " u_userstatus = :userStatus ,\r\n"
			+ " u_surname = :lastName \r\n"
			+ "where u_username = :username ", nativeQuery = true)
	void updateUserByUsername(String username, String firstName, String lastName, String newUsername, String email,
			String password, String phone, Integer userStatus);
}
