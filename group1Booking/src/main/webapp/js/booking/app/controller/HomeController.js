/*
 * File: app/controller/HomeController.js
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

Ext.define('layout.controller.HomeController', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'comgrp1bkgvpHome',
            selector: '#com.grp1.bkg.vpHome'
        },
        {
            ref: 'tabHomebtnSearch',
            selector: '#tabHomebtnSearch'
        },
        {
            ref: 'mygridpanel',
            selector: '#mygridpanel'
        },
        {
            ref: 'homeBtnViewBkg',
            selector: '#homeBtnViewBkg'
        }
    ],

    onTabHomebtnSearchClick: function(button, e, eOpts) {
        var modelId = 'layout.model.';
        		var bkg =Ext.getCmp('tabHometxtfBkgNo').getValue();
            	var cntr = Ext.getCmp('tabHomeTxtFCntrNo').getValue();
            	var city = Ext.getCmp('tabHomeTxtFFrmCity').getValue();
            	var tcity = Ext.getCmp('tabHomeTxtFToCity').getValue();
            	var searchModel = Ext.create(modelId + 'searchBookingByAny', {
            		bookingNo : bkg,
           			containerNo : cntr,
           			frmCity : city,
           			toCity : tcity
           		});

        Ext.Ajax.request({
        			url : 'homeSearch',
        			method : 'POST',
        			jsonData : Ext.encode(searchModel.data),
        			success : function(response) {
        				debugger;
        				//var res = Ext.decode(response.responseText);
        				var res = JSON.parse(response.responseText);
                        var store = Ext.getStore('BookingInfoStore');
                        store.removeAll();
                        store.add(res);
                        console.log(store);
                        //Ext.getCmp('#mygridpanel').getStore().reload();
                        //Ext.getCmp('#mygridpanel').getStore().load();
        			},
        			failure : function(response) {
        				alert("Login Failed");
        				console.log(response);
                        var store = Ext.getStore('BookingInfoStore');
                        store.removeAll();
                        store.add([{BOOKING_NUM:123},{BOOKING_NUM:124}]);
                        console.log(store);
        				console.log("Update function ajax request failed");
        			}
        		});
    },

    init: function(application) {
        this.control({
            "#tabHomebtnSearch": {
                click: this.onTabHomebtnSearchClick
            },
            "#homeBtnViewBkg": {
                click: this.onHomeBtnViewBkgClick
            }
        });
    }

});
