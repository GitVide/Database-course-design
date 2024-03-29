package scu.cj.community.mapper;

import java.util.List;
import scu.cj.community.model.User;
import scu.cj.community.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_user
     *
     * @mbg.generated Fri Dec 13 20:10:37 CST 2019
     */
    int updateByPrimaryKey(User record);


    User validationUser(String studentId,String password);

    boolean insertNewUser(User user);

    User findIfStudentIdExits(String studentId);

    List<User> findAllUser();

    User getUserById(@Param("id") Long id);
    int updateUserInfo(String name,String password,String bio,Long id);

}