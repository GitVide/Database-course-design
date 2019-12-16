package scu.cj.community.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.id
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.ACCOUNT_ID
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.NAME
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.TOKEN
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.GMT_CREATE
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.GMT_MODIFIED
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.bio
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column github_user.avatar_url
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    private String avatarUrl;

    private  String password;
    private String isSuper;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.id
     *
     * @return the value of github_user.id
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.id
     *
     * @param id the value for github_user.id
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.ACCOUNT_ID
     *
     * @return the value of github_user.ACCOUNT_ID
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.ACCOUNT_ID
     *
     * @param accountId the value for github_user.ACCOUNT_ID
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.NAME
     *
     * @return the value of github_user.NAME
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.NAME
     *
     * @param name the value for github_user.NAME
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.TOKEN
     *
     * @return the value of github_user.TOKEN
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.TOKEN
     *
     * @param token the value for github_user.TOKEN
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.GMT_CREATE
     *
     * @return the value of github_user.GMT_CREATE
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.GMT_CREATE
     *
     * @param gmtCreate the value for github_user.GMT_CREATE
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.GMT_MODIFIED
     *
     * @return the value of github_user.GMT_MODIFIED
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.GMT_MODIFIED
     *
     * @param gmtModified the value for github_user.GMT_MODIFIED
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.bio
     *
     * @return the value of github_user.bio
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.bio
     *
     * @param bio the value for github_user.bio
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column github_user.avatar_url
     *
     * @return the value of github_user.avatar_url
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column github_user.avatar_url
     *
     * @param avatarUrl the value for github_user.avatar_url
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}