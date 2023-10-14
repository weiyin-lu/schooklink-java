package online.weiyin.service.impl;

import online.weiyin.entity.Users;
import online.weiyin.mapper.UsersMapper;
import online.weiyin.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
