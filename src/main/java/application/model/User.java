package application.model;


public class User {

  private String idUserPk;
  private String password;
  private String name;
  private String role;
  private String adUser;


  public String getIdUserPk() {
    return idUserPk;
  }

  public void setIdUserPk(String idUserPk) {
    this.idUserPk = idUserPk;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  public String getAdUser() {
    return adUser;
  }

  public void setAdUser(String adUser) {
    this.adUser = adUser;
  }

}
