package online.weiyin.dto;

import lombok.Data;

/**
 * @ClassName RegisterDTO
 * @Description 注册dto
 * @Version 1.0.0
 * @Time 2023/10/15 下午 03:55
 * @Author 卢子昂
 */
@Data
public class RegisterDTO {
    private String userType;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String grade;
    private String gender;

}
