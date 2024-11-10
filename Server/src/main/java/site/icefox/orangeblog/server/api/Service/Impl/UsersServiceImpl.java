package site.icefox.orangeblog.server.api.Service.Impl;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import site.icefox.orangeblog.server.Common.Util.PasswdUtil;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;
import site.icefox.orangeblog.server.Domain.Mapper.UsersMapper;
import site.icefox.orangeblog.server.api.Dto.UsersDto;
import site.icefox.orangeblog.server.api.Service.Interface.UsersService;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public UsersDto queryUsersByEmail(String email) {
        UsersEntity user = usersMapper.queryUserbyEmail(email);
        if (user == null) {
            throw new RuntimeException("获取用户信息失败");
        }
        UsersDto result = new UsersDto();
        BeanUtils.copyProperties(user, result);
        return result;
    }

    @Override
    public UsersDto login(String email, String password) {
        UsersEntity user = usersMapper.queryUserbyEmail(email);
        if (user != null && PasswdUtil.verifyPasswd(password, user.getPassword())) {
            UsersDto result = new UsersDto();
            BeanUtils.copyProperties(user, result);
            return result;
        }
        throw new RuntimeException("Invalid Email or Password!");
    }

    @Override
    public List<UsersDto> queryAllUsers() {
        List<UsersEntity> list = usersMapper.queryAllUsers();
        List<UsersDto> resultList = new ArrayList<>();
        for (UsersEntity user : list) {
            UsersDto result = new UsersDto();
            BeanUtils.copyProperties(user, result);
            resultList.add(result);
        }
        return resultList;
    }

    @Override
    public UsersDto saveUser(UsersEntity newUser) {
        //TODO 验证邮箱格式
        String Emailpattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (newUser.getEmail() == null || !newUser.getEmail().matches(Emailpattern)) {
            throw new RuntimeException("Email格式错误!");
        }
        //TODO 验证邮箱是否已被注册
        UsersEntity user = usersMapper.queryUserbyEmail(newUser.getEmail());
        if (user != null) {
            throw new RuntimeException("该邮箱已被注册!");
        }
        //TODO 验证用户名格式
        String Namepattern = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{3,10}$";
        if (newUser.getUsername() == null || !newUser.getUsername().matches(Namepattern)) {
            throw new RuntimeException("用户名格式错误!");
        }
        //TODO 验证密码格式，至少包含数字0-9，大小写字母的一种和特殊符号（只能是!@%&*,.?)，长度不低于8位，不高于32位
        if (!PasswdUtil.isValidPassword(newUser.getPassword())) {
            throw new RuntimeException("密码格式错误!");
        }
        newUser.setPassword(PasswdUtil.encryptPasswd(newUser.getPassword()));
        //TODO 写入数据库
        usersMapper.saveUser(newUser);
        //TODO 返回结果
        user = usersMapper.queryUserbyEmail(newUser.getEmail());
        UsersDto result = new UsersDto();
        BeanUtils.copyProperties(user, result);
        return result;
    }
}
