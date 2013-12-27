<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>冰川基本系统</title>
		<!-- 引入公用的js和样式库 -->
		<jsp:include page="inc.jsp"/>
		<script type="text/javascript" charset="utf-8">
			$(function() {
				//初始化导航
				$('#layout_west_tree').tree({
					url : ctx +'/do/res/menu/getPrincipalUserMenu.json',
					smooth: true,       //该属性用以启用当前 easyui-tree 控件对平滑数据格式的支持
					lines : true,
					onClick : function(node) {
						var url;
						if (node.attributes.url) {//获取树节点中自定义属性的url属性
							url = ctx + node.attributes.url;
							layout_center_addTabFun({//调用glacier.util.js中的动态增加tab方法
								title : node.text,
								closable : true,
								iconCls : node.iconCls,
								href : url
							});
						}
					}
				});
				//初始化tab菜单
				$('#layout_center_tabsMenu').menu({
					onClick : function(item) {
						var curTabTitle = $(this).data('tabTitle');
						var type = $(item.target).attr('type');
	
						if (type === 'refresh') {
							layout_center_refreshTab(curTabTitle);
							return;
						}
	
						if (type === 'close') {
							var t = $('#layout_center_tabs').tabs('getTab', curTabTitle);
							if (t.panel('options').closable) {
								$('#layout_center_tabs').tabs('close', curTabTitle);
							}
							return;
						}
	
						var allTabs = $('#layout_center_tabs').tabs('tabs');
						var closeTabsTitle = [];
	
						$.each(allTabs, function() {
							var opt = $(this).panel('options');
							if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
								closeTabsTitle.push(opt.title);
							} else if (opt.closable && type === 'closeAll') {
								closeTabsTitle.push(opt.title);
							}
						});
	
						for ( var i = 0; i < closeTabsTitle.length; i++) {
							$('#layout_center_tabs').tabs('close', closeTabsTitle[i]);
						}
					}
				});
				//初始化tab
				$('#layout_center_tabs').tabs({
					fit : true,
					border : false,
					onContextMenu : function(e, title) {
						e.preventDefault();
						$('#layout_center_tabsMenu').menu('show', {
							left : e.pageX,
							top : e.pageY
						}).data('tabTitle', title);
					},
					tools : [ {
						iconCls : 'icon-reload',
						border : false,
						handler : function() {
							var href = $('#layout_center_tabs').tabs('getSelected').panel('options').href;
							if (href) {/*说明tab是以href方式引入的目标页面*/
								var index = $('#layout_center_tabs').tabs('getTabIndex', $('#layout_center_tabs').tabs('getSelected'));
								$('#layout_center_tabs').tabs('getTab', index).panel('refresh');
							} else {/*说明tab是以content方式引入的目标页面*/
								var panel = $('#layout_center_tabs').tabs('getSelected').panel('panel');
								var frame = panel.find('iframe');
								try {
									if (frame.length > 0) {
										for ( var i = 0; i < frame.length; i++) {
											frame[i].contentWindow.document.write('');
											frame[i].contentWindow.close();
											frame[i].src = frame[i].src;
										}
										if ($.browser.msie) {
											CollectGarbage();
										}
									}
								} catch (e) {
								}
							}
						}
					}, {
						iconCls : 'icon-cancel',
						handler : function() {
							var index = $('#layout_center_tabs').tabs('getTabIndex', $('#layout_center_tabs').tabs('getSelected'));
							var tab = $('#layout_center_tabs').tabs('getTab', index);
							if (tab.panel('options').closable) {
								$('#layout_center_tabs').tabs('close', index);
							} else {
								$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭', 'error');
							}
						}
					} ]
				});
			});
			
			//刷新tab面板方法
			function layout_center_refreshTab(title) {
				$('#layout_center_tabs').tabs('getTab', title).panel('refresh');
			};
			//动态增加tab
			function layout_center_addTabFun(opts) {
				var t = $('#layout_center_tabs');
				if (t.tabs('exists', opts.title)) {
					t.tabs('select', opts.title);
				} else {
					t.tabs('add', opts);
				}
			};
			//用户退出系统方法
			function logoutFun(){
				window.location.href = ctx + '/do/login.htm';
			};
			//查看当前用户权限方法
			function currentUserResource(){
			};
		</script>
	</head>
	<body class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'north',border:false" style="height:60px;overflow:hidden;">
			<div style="position: absolute; right: 0px; bottom: 0px;">
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'cog'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'cog'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'cog'">注销</a>
			</div>
			<div id="layout_north_pfMenu" style="width: 120px; display: none;">
				<div onclick="changeThemeFun('default');" title="default">default</div>
				<div onclick="changeThemeFun('gray');" title="gray">gray</div>
				<div onclick="changeThemeFun('metro');" title="metro">metro</div>
				<div onclick="changeThemeFun('bootstrap');" title="bootstrap">bootstrap</div>
				<div onclick="changeThemeFun('black');" title="black">black</div>
				<div onclick="changeThemeFun('cupertino');" title="cupertino">cupertino</div>
				<div onclick="changeThemeFun('dark-hive');" title="dark-hive">dark-hive</div>
				<div onclick="changeThemeFun('pepper-grinder');" title="pepper-grinder">pepper-grinder</div>
				<div onclick="changeThemeFun('sunny');" title="sunny">sunny</div>
				<div onclick="changeThemeFun('metro-blue');" title="metro-blue">metro-blue</div>
				<div onclick="changeThemeFun('metro-gray');" title="metro-gray">metro-gray</div>
				<div onclick="changeThemeFun('metro-green');" title="metro-green">metro-green</div>
				<div onclick="changeThemeFun('metro-orange');" title="metro-orange">metro-orange</div>
				<div onclick="changeThemeFun('metro-red');" title="metro-red">metro-red</div>
			</div>
			<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
				<div onclick="editCurrentUserPwd();">修改密码</div>
				<div class="menu-sep"></div>
				<div onclick="currentUserRole();">我的角色</div>
				<div class="menu-sep"></div>
				<div onclick="currentUserResource();">我的权限</div>
			</div>
			<div id="layout_north_zxMenu" style="width: 100px; display: none;">
				<div onclick="logoutFun();">退出系统</div>
			</div>
		</div>
		<div data-options="region:'west',split:true" style="width:160px;overflow:hidden;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="导航" data-options="iconCls:'anchor',tools : [{
							iconCls : 'database_refresh',
							handler : function() {
								$('#layout_west_tree').tree('reload');
							}
						}, {
							iconCls : 'resultset_next',
							handler : function() {
								var node = $('#layout_west_tree').tree('getSelected');
								if (node) {
									$('#layout_west_tree').tree('expandAll', node.target);
								} else {
									$('#layout_west_tree').tree('expandAll');
								}
							}
						}, {
							iconCls : 'resultset_previous',
							handler : function() {
								var node = $('#layout_west_tree').tree('getSelected');
								if (node) {
									$('#layout_west_tree').tree('collapseAll', node.target);
								} else {
									$('#layout_west_tree').tree('collapseAll');
								}
							}
						}]">
					<ul id="layout_west_tree"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'" style="overflow: hidden;">
			<div id="layout_center_tabs" style="overflow: hidden;">
				<div title="首页"></div>
			</div>
			<div id="layout_center_tabsMenu" style="width: 120px;display:none;">
				<div type="refresh" data-options="iconCls:'icon-reload'">刷新</div>
				<div class="menu-sep"></div>
				<div type="close" data-options="iconCls:'icon-cancel'">关闭</div>
				<div type="closeOther" data-options="iconCls:'icon-cancel'">关闭其他</div>
				<div type="closeAll" data-options="iconCls:'icon-cancel'">关闭所有</div>
			</div>
		</div>
	</body>
</html>