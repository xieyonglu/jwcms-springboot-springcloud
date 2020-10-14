package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.User;

/*** 
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author eacdy
 */
@RestController
public class UserController {

	/***
	 * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于： * @RequestMapping(value = "/id",
	 * method = RequestMethod.GET) * 类似的注解还有@PostMapping等等 * @param id * @return
	 * user信息
	 */
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) throws Exception {
//		User findOne = this.userRepository.findOne(id);
//		return findOne;
		System.out.println("====>>>>>>" + id);
		if(true) {
			throw new Exception("========");
		}
		return null;
	}

}
