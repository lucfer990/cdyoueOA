<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户登录-成都优易OA</title>
<!-- 引入公共css -->
<%@ include file="/common/base_css.jsp"%>
<link rel="stylesheet" href="${basePath}/css/login.css" />
<!-- 引入公共js -->
<%@include file="/common/base_js.jsp"%>

<script src="${basePath}/static/js/common.js"></script>

<!-- 云彩特效 -->
<script type="text/javascript"
	src="${basePath}/static/plugins/loginSpecialEffects/ThreeWebGL.js"></script>
<script type="text/javascript"
	src="${basePath}/static/plugins/loginSpecialEffects/lanrenzhijia.js"></script>
<script type="text/javascript"
	src="${basePath}/static/plugins/loginSpecialEffects/ThreeExtras.js"></script>
<script type="text/javascript"
	src="${basePath}/static/plugins/loginSpecialEffects/RequestAnimationFrame.js"></script>
	
<script id="vs" type="x-shader/x-vertex">
			varying vec2 vUv;
			void main() {
				vUv = uv;
				gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
			}
		</script>
<script id="fs" type="x-shader/x-fragment">
			uniform sampler2D map;
			uniform vec3 fogColor;
			uniform float fogNear;
			uniform float fogFar;
			varying vec2 vUv;
			void main() {
				float depth = gl_FragCoord.z / gl_FragCoord.w;
				float fogFactor = smoothstep( fogNear, fogFar, depth );
				gl_FragColor = texture2D( map, vUv );
				gl_FragColor.w *= pow( gl_FragCoord.z, 20.0 );
				gl_FragColor = mix( gl_FragColor, vec4( fogColor, gl_FragColor.w ), fogFactor );
			}
		</script>

<script src="${basePath}/static/js/login.js"></script>
</head>
<body class="login-layout">
	<div class="main-container login-title">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<%-- <a href="${basePath}/login.do"> --%> <img alt="成都优易"
									src="${basePath}/images/logo.png" height="45px">
								</a> <br> <br> <br> <br> <span class="red">成都优易数据</span>
								<span class="white">OA系统</span>
							</h1>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main" style="background:	floralwhite;">
										<h4 class="header blue lighter bigger">
											<i class="icon-edit green"></i> 请输入您的信息
										</h4>

										<div class="space-6"></div>

										<form id="login-form">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" id="USER_ID" name="USER_ID"
														placeholder="请输入用户名" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" id="pswd"
														name="pswd" placeholder="请输入密码" /> <i
														class="icon-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<button id="loginBtn" type="button" onclick="login()"
														class="width-35 pull-cinter btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
													<span id="message"></span>
												</div>

											</fieldset>
										</form>

									</div>
									<!-- /widget-main -->

									<!-- <div class="toolbar clearfix">
										<div>
											<a href="#" onclick="show_box('forgot-box'); return false;"
												class="forgot-password-link"> <i class="icon-arrow-left"></i>
												忘记密码！
											</a>
										</div>

										<div>
											<a href="#" onclick="show_box('signup-box'); return false;"
												class="user-signup-link"> 快速注册<i
												class="icon-arrow-right"></i>
											</a>
										</div>
									</div> -->
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->

							<!-- <div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="icon-key"></i> 找回密码
										</h4>

										<div class="space-6"></div>
										<p>输入您的邮箱地址以接收新密码！</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="请输入注册的邮箱地址" />
														<i class="icon-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="icon-lightbulb"></i> 发送
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									/widget-main

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> 返回登录<i
											class="icon-arrow-right"></i>
										</a>
									</div>
								</div>
								/widget-body
							</div> -->
							<!-- /forgot-box -->

							<!-- <div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="icon-group blue"></i> 新用户注册
										</h4>

										<div class="space-6"></div>
										<p>填写注册信息:</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="邮箱地址" /> <i
														class="icon-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="用户名" /> <i
														class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="登陆密码" />
														<i class="icon-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="重复密码" />
														<i class="icon-retweet"></i>
												</span>
												</label> <label class="block"> <input type="checkbox"
													class="ace" /> <span class="lbl"> 我接受<a href="#">用户协议</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="icon-refresh"></i> 重置
													</button>

													<button type="button"
														class="width-65 pull-right btn btn-sm btn-success">
														注册 <i class="icon-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> <i class="icon-arrow-left"></i>
											返回登录
										</a>
									</div>
								</div>
								/widget-body
							</div> -->
							<!-- /signup-box -->
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->
	<script
		src="${basePath}/static/plugins/ace/fuelux/fuelux.wizard.min.js"></script>
	<script src="${basePath}/static/plugins/ace/jquery.validate.min.js"></script>
<!-- 	<script src="${basePath}/static/plugins/ace/additional-methods.min.js"></script> -->
<!-- 	<script src="${basePath}/static/plugins/ace/bootbox.min.js"></script> -->
	<script src="${basePath}/static/plugins/ace/select2.min.js"></script>
</body>
</html>
