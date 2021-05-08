package swagger2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ExternalDocs;
import springfox.documentation.annotations.ApiIgnore;
import swagger2.model.Users;

/**
 * http://localhost:8080/swagger-ui.html 
 * 
 * Swagger常用注解：
 * @Api：用在類上，說明該類的作用； 
 * @ApiOperation：用在方法上，說明方法的作用； 
 * @ApiImplicitParams：用在方法上包含一組參數說明； 
 * @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一個請求參數的各個方面:
 *                    paramType：參數放在哪個地方； header-->請求參數的獲取：@RequestHeader；
 *                    query-->請求參數的獲取：@RequestParam；
 *                    path-->請求參數的獲取：@PathVariable （用於restful介面）； body（不常用）；
 *                    form（不常用）； name： 參數名； dataType：參數類型； required：參數是否必須傳；
 *                    value：參數的意思； defaultValue：參數的預設值；
 * @ApiResponses：用於表示一組回應； 
 * @ApiResponse：用在@ApiResponses中，一般用於表達一個錯誤的響應資訊；
 *                         code：數位，例如400； message：資訊，例如 "請求參數不合法"；
 *                         response：拋出異常的類；
 * @ApiIgnore：使用該注解忽略這個API，在頁面上不顯示； 
 * @ApiModel：描述一個Model的資訊； 
 * @ApiModelProperty：描述一個model的屬性；
 *                                  
 *   注解可參考官方：https://github.com/swagger-api/swagger-core/wiki/Annotations
 *   WebJars是將Web前端Javascript和CSS等資源打包成Java的Jar包,這樣在Java
 *   Web開發中我們可以借助Maven這些依賴庫的管理,保證這些Web資源版本唯一性；
 *   swagger安全性問題: 正式上線的時候，建議關閉swagger；
 * 
 * @author Dustin
 *
 */
@Api(tags = "springboot使用swagger测试")
@RestController
public class SwaggerController {

    @ApiOperation(value = "获取用户信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID",  dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "status", value = "用户状态", dataType = "Integer"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "缺少必要的请求参数"),
            @ApiResponse(code = 401, message = "请求路径没有相应权限"),
            @ApiResponse(code = 403, message = "请求路径被隐藏不能访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405, message = "请求方法不支持"),
    })

    @RequestMapping(value = "/swagger/user/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody Users getUserInfo(@PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        Users users = new Users();
        users.setId(id);
        users.setNick("cat");
        users.setPhone("1370000000");
        users.setPassword("******");
        users.setEmail("cat@163.com");
        users.setAccount("NO68958886878664");
        return users;
    }

    @ApiOperation(value = "添加用户信息", notes = "将用户信息提交保存到数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "users", value = "用户对象", dataTypeClass = Users.class)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "缺少必要的请求参数"),
            @ApiResponse(code = 401, message = "请求路径没有相应权限"),
            @ApiResponse(code = 403, message = "请求路径被隐藏不能访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405, message = "请求方法不支持"),
    })
    @RequestMapping(value = "/swagger/users", method = RequestMethod.POST)
    public @ResponseBody Users postUserInfo(@RequestBody Users users) {
        return users;
    }

    @ApiOperation(value = "修改用户信息", notes = "将用户信息修改保存到数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "users", value = "用户对象", dataTypeClass = Users.class)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "缺少必要的请求参数"),
            @ApiResponse(code = 401, message = "请求路径没有相应权限"),
            @ApiResponse(code = 403, message = "请求路径被隐藏不能访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405, message = "请求方法不支持"),
    })
    @RequestMapping(value = "/swagger/users", method = RequestMethod.PUT)
    public @ResponseBody Users putUserInfo(@RequestBody Users users) {
        return users;
    }

    @ApiOperation(value = "删除户信息", notes = "将用户信息从数据库删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户ID", dataType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "缺少必要的请求参数"),
            @ApiResponse(code = 401, message = "请求路径没有相应权限"),
            @ApiResponse(code = 403, message = "请求路径被隐藏不能访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405, message = "请求方法不支持"),
    })
    @ApiIgnore(value = "忽略这个api")
    @ExternalDocs(value = "扩展文档", url = "http://www.baidu.com")
    @RequestMapping(value = "/swagger/users", method = RequestMethod.DELETE)
    public @ResponseBody Integer deleteUserInfo(@RequestParam("id") Integer id) {
        return 100;
    }
}
