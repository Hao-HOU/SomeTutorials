package test.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_user_role
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysUserRole {
    /**
     * Database Column Remarks:
     *   用户 ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * Database Column Remarks:
     *   角色 ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.role_id
     *
     * @mbggenerated
     */
    private Long roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.user_id
     *
     * @return the value of sys_user_role.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.user_id
     *
     * @param userId the value for sys_user_role.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.role_id
     *
     * @return the value of sys_user_role.role_id
     *
     * @mbggenerated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.role_id
     *
     * @param roleId the value for sys_user_role.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}