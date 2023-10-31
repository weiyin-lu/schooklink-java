package online.weiyin.util;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import online.weiyin.entity.Users;
import online.weiyin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StpInterfaceImpl
 * @Description ST-token权限组和角色组配置
 * @Version 1.0.0
 * @Time 2023/10/15 下午 02:42
 * @Author 卢子昂
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    UsersService usersService;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    /**
     * 角色查询
     *
     * @param loginId 当前登录用户的账号（业务角度唯一性ID）
     * @param s
     * @return 当前用户的角色
     */
    @Override
    public List<String> getRoleList(Object loginId, String s) {
//        查询当前用户的角色标识，该标识必然只有一个
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<Users>()
                .eq("username", loginId);
        Users one = usersService.getOne(usersQueryWrapper);
//        插入到一个list里（该方法必须返回list）
        ArrayList<String> list = new ArrayList<>();
        list.add(one.getUserType());
        return list;
    }
}
