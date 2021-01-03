
package rentelproject.lk.ijse.rent.model;

public class Login {
    private String userName = "project";
    private String password = "ijse";

    public Login() {
    }
    
    @Override
    public String toString() {
        return "LoginController{" + "userName=" + getUserName() + ", password=" + getPassword() + '}';
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
}
