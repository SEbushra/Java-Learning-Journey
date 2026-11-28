public class User {
    private final int id;
    private String fullName;
    private String email;
    private String hashedPassword;
    private Role role;

    User(String fullName , String email , String hashedPassword){

        setFullName(fullName);
        setEmail(email);
        setPasswordHash(hashedPassword);

        
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Role getRole() {
        return role;
    }


    public void setFullName(String fullName) {
        if(fullName==null || fullName.isBlank()){
            throw new IllegalArgumentException("Full name cannot be empty.");
        }

        this.fullName = fullName.trim();
    }

    public void setEmail(String email) {
        if(email==null || !email.contains("@") || !email.contains(".")){
            throw new IllegalArgumentException("Please enter a valid email address.");
        }
        this.email = email.trim();
    }

    public void setPasswordHash(String hashedPassword){
        if(hashedPassword==null ||hashedPassword.isBlank()){
            throw new IllegalArgumentException ("Password cannot be empty.");
        }
        this.hashedPassword = hashedPassword;
    }

}
