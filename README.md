# TAPermission (Kotlin版)

一个基于Android 10的简便权限请求库

## 基本使用

#### 1.添加Gradle依赖

Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
	dependencies {
	        implementation 'com.github.taa1007:TAPermission:1.0.0'
	}
```

#### 2.一句代码搞定权限请求，从未如此简单
           /*
            * 支持一次性请求多个权限
            * */
            TAPermission.request(
                this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) { allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You  Denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
            
#### 框架亮点

* 简洁易用，采用链式调用的方式，使用只需一句代码

* 支持单个权限、多个权限、单个权限组、多个权限组请求


#### TODO

- [ ] 支持大部分国产手机直接跳转到具体的权限设置页面

- [ ] 可设置被拒绝后继续申请，直到用户授权或者永久拒绝

- [ ] 待办事项1支持请求6.0及以上的悬浮窗权限和8.0及以上的安装权限




- [x] 已完成事项
