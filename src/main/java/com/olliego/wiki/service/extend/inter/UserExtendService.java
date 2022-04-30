package com.olliego.wiki.service.extend.inter;

import com.olliego.wiki.param.user.UserLoginParam;
import com.olliego.wiki.param.user.UserResetPasswordParam;
import com.olliego.wiki.param.user.UserSaveParam;
import com.olliego.wiki.param.user.UserSearchParam;
import com.olliego.wiki.result.PageVO;
import com.olliego.wiki.result.RestResult;
import com.olliego.wiki.result.UserVO;

public interface UserExtendService {

    RestResult<PageVO<UserVO>> queryPage(UserSearchParam param);

    RestResult save(UserSaveParam param);

    RestResult delete(Long id);

    RestResult resetPassword(UserResetPasswordParam param);

    RestResult login(UserLoginParam param);
}
