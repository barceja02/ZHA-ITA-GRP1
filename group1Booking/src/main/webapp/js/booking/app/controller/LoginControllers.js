/*
 * File: app/controller/LoginControllers.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('layout.controller.LoginControllers', {
	extend : 'Ext.app.Controller',

	onBtnLoginClick : function(button, e, eOpts) {
		var modelId = 'layout.model.'
			
		var user = Ext.create(modelId + 'loginInfo', {
		    username : Ext.getCmp('txtUsername').getValue(),
		    password : Ext.getCmp('txtPassword').getValue()
		});
		
		Ext.Ajax.request({
			url : 'login',
			method : 'POST',
			jsonData : Ext.encode(user.data),
			success : function(response) {
				var res = Ext.decode(response.responseText);
				var userInfo = Ext.create(modelId + 'loginResponse', {
					userId : res.userId,
					role :  res.role,
					userName :  res.userName,
					isSuccess :  res.isSuccess
				});
				console.log(userInfo.data.isSuccess);
				if(userInfo.data.isSuccess === "true"){
					this.vpHome = Ext.create('layout.view.com.grp1.bkg.vpHome');
					this.vpHome.show();
				}
			},
			failure : function(response) {
				var jsonn = '{isSuccess: "true",role: "userkoto",userId: 123}';
				var res = Ext.decode(jsonn);
				console.log(res);
				console.log("Update function ajax request failed");
			}
		});

	},

	init : function(application) {
		this.control({
			"#btnLogin" : {
				click : this.onBtnLoginClick
			}
		});
	}

});


