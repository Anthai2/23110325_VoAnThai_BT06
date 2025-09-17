package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "username") private String username;
  @Column(name = "password") private String password;
  @Column(name = "fullname", columnDefinition = "NVARCHAR(255)") private String fullName;
  @Column(name = "email") private String email;
  @Column(name = "phone") private String phone;
  @Column(name = "avatar") private String avatar;
  @Column(name = "roleid") private Integer roleId;
  @Column(name = "createDate") private LocalDateTime createDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public Integer getRoleId() {
	return roleId;
}
public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}
public LocalDateTime getCreateDate() {
	return createDate;
}
public void setCreateDate(LocalDateTime createDate) {
	this.createDate = createDate;
}
  
}
