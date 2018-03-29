Feature: Sign in and login with baidu account

  Scenario Outline: sign in baidu with new account

	Given User open a "<web_site>"
	And Click "<button>"
    Then Click "<sign_button>" and navigate to sign web page
	And Input "<username>" "<number>" "<password>" and selected related policy
	Then Submit sign request to click "<submit_button>"

	Examples:
	| web_site             | button | sign_button | username | number     | password | submit_button |
	| http://www.baidu.com | 登录         | 立即注册      | qaworkshop | 13932277223 | workshop | 注册  |

	@wip
  Scenario Outline: login baidu with new account

	Given User open a "<web_site>"
	And Click "<button>"
	Then Click "<login_link>" and navigate to login web page
	And Input "<user>" "<password>" on login page
	Then Submit "<submit_button>"
	And User login successfully with "<username>"


	Examples:
	  | web_site             | button      | login_link | user                | password      | submit_button | username    |
	  | http://www.baidu.com | 登录         | 用户名登录   | vickey_1108@163.com | Vickey@11081  | 登录           | Vickeyfly16 |