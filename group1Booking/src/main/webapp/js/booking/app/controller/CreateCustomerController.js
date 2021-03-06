/*
 * File: app/controller/CreateCustomerController.js
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
var customerWindow;
var action;
Ext.define('layout.controller.CreateCustomerController', {
    extend: 'Ext.app.Controller',

    id: 'CreateCustomerController',

    refs: [
        {
            ref: 'comgrp1bkgCreateCustomer',
            selector: '#CreateCustomer'
        },
        {
            ref: 'customerbtnCreate',
            selector: '#customerbtnCreate'
        },
        {
            ref: 'tabCustomerBtnSearch',
            selector: '#tabCustomerBtnSearch'
        },
        {
            ref: 'tabCustomerBtnEdit',
            selector: '#tabCustomerBtnEdit'
        },
        {
            ref: 'tabCustomerBtnBrowse',
            selector: '#tabCustomerBtnBrowse'
        }
    ],

    onTabCustomerBtnCreateClick: function(button, e, eOpts) {
    	action = 'Create';
        customerWindow = Ext.create('layout.view.com.grp1.bkg.CreateCustomer');
        customerWindow.show();
        Ext.getCmp('customertxtfCustomerId').setVisible(false);

    },
    
    //Browse
    onTabCustomerBtnBrowseClick: function(button, e, eOpts) {
    	action = 'View';
  		 var grid = Ext.getCmp('customerGridPanel');
         if(grid.getSelectionModel().getSelection().length===1){
         var selected = grid.getSelectionModel().getSelection();
         var selectedCustomer = [];
         Ext.iterate(selected,function(key){
         selectedCustomer.push({selected:key.data}) ;
        
         });
         console.log('---');
         console.log(selectedCustomer[0]);
         customerWindow = Ext.create('layout.view.com.grp1.bkg.CreateCustomer');
         Ext.getCmp('customertxtfFirstName').setValue(selectedCustomer[0].selected.firstname);
         Ext.getCmp('customertxtfLastName').setValue(selectedCustomer[0].selected.lastname);
         Ext.getCmp('customerwindowtxtfAddress').setValue(selectedCustomer[0].selected.address);
         Ext.getCmp('customerwindowtxtfCompanyName').setValue(selectedCustomer[0].selected.companyName);
         Ext.getCmp('customertxtfContactNumber').setValue(selectedCustomer[0].selected.contactNumber);
         Ext.getCmp('customertxtfEmail').setValue(selectedCustomer[0].selected.mailAddress);
         Ext.getCmp('customertxtfRole').setValue(selectedCustomer[0].selected.role);
         if(selectedCustomer[0].selected.isActive==true){
         	Ext.getCmp('customerchkboxActive').setValue(true);
         }else{
         	Ext.getCmp('customerchkboxActive').setValue(false);
         }
  		customerWindow.setTitle("Browse Customer");
  		customerWindow.show();
  		//readonly
  		 Ext.getCmp('customertxtfFirstName').setReadOnly(true);
  		Ext.getCmp('customertxtfLastName').setReadOnly(true);
  		Ext.getCmp('customerwindowtxtfAddress').setReadOnly(true);
  		Ext.getCmp('customerwindowtxtfCompanyName').setReadOnly(true);
  		Ext.getCmp('customertxtfContactNumber').setReadOnly(true);
  		Ext.getCmp('customertxtfEmail').setReadOnly(true);
  		Ext.getCmp('customertxtfRole').setReadOnly(true);
  		Ext.getCmp('customerchkboxActive').setReadOnly(true);
  		//hide 
        Ext.getCmp('customertxtfCustomerId').setVisible(false);
  		Ext.getCmp('customertxtfUsername').setVisible(false);
  		Ext.getCmp('customertxtfPassword').setVisible(false);
  		Ext.getCmp('customerbtnCreate').setVisible(false);
         }else{
             alert('Select only 1 record to view');
         }
    },
    onTabCustomerBtnEditClick: function(button, e, eOpts) {
    	action = 'Update';
    	 var grid = Ext.getCmp('customerGridPanel');
         if(grid.getSelectionModel().getSelection().length===1){
         var selected = grid.getSelectionModel().getSelection();
         var selectedCustomer = [];
         Ext.iterate(selected,function(key){
         selectedCustomer.push({selected:key.data}) ;
        
         });
         console.log('---');
         console.log(selectedCustomer[0]);
         customerWindow = Ext.create('layout.view.com.grp1.bkg.CreateCustomer');
  		Ext.getCmp('customertxtfCustomerId').setValue(selectedCustomer[0].selected.customerId);
         Ext.getCmp('customertxtfFirstName').setValue(selectedCustomer[0].selected.firstname);
         Ext.getCmp('customertxtfLastName').setValue(selectedCustomer[0].selected.lastname);
         Ext.getCmp('customerwindowtxtfAddress').setValue(selectedCustomer[0].selected.address);
         Ext.getCmp('customerwindowtxtfCompanyName').setValue(selectedCustomer[0].selected.companyName);
         Ext.getCmp('customertxtfContactNumber').setValue(selectedCustomer[0].selected.contactNumber);
         Ext.getCmp('customertxtfEmail').setValue(selectedCustomer[0].selected.mailAddress);
         Ext.getCmp('customertxtfRole').setValue(selectedCustomer[0].selected.role);
         if(selectedCustomer[0].selected.isActive==true){
         	Ext.getCmp('customerchkboxActive').setValue(true);
         }else{
         	Ext.getCmp('customerchkboxActive').setValue(false);
         }
  		customerWindow.show();
  		customerWindow.setTitle("Update Customer");
  		customerWindow.show();
  		Ext.getCmp('customertxtfUsername').setVisible(false);
  		Ext.getCmp('customertxtfPassword').setVisible(false);
  		Ext.getCmp('customerbtnCreate').setText(action);
         }else{
             alert('Select only 1 record to view');
         }
        
     
       
    },
    onTabCustomerBtnSearchClick: function(button, e, eOpts) {
    	
       var modelId = 'layout.model.';
       
    	var searchCustomer = Ext.create(modelId + 'SearchCustomerModel',{
    		companyName: Ext.getCmp('customertxtfCompanyName').getValue(),
    		address: Ext.getCmp('customertxtfAddress').getValue()
    	});
    	
        Ext.Ajax.request({
			url : 'searchCustomerByCriteria',
			method : 'POST',
			jsonData : Ext.encode(searchCustomer.data),
			success : function(response) {
				//var res = Ext.decode(response.responseText);
				var res = JSON.parse(response.responseText);
                var store = Ext.getStore('CustomerStore');
                store.removeAll();
                store.add(res);
                console.log(store);
			},
			failure : function(response) {
                alert('Failed to search');
			}
		});
    	
    },

    onCustomerbtnCreateClick: function(button, e, eOpts) {
    	if(action==='Create'){
    		console.log('Create CUstomer');
        var modelId = 'layout.model.';
        var checkActive;
        if(Ext.getCmp('customerchkboxActive').getValue()===true){
            checkActive = 1;
        }else{
            checkActive = 0;
        }
        		var customer = Ext.create(modelId + 'CustomerCreationModel', {
                    firstname : Ext.getCmp('customertxtfFirstName').getValue(),
                    lastname : Ext.getCmp('customertxtfLastName').getValue(),
                     address : Ext.getCmp('customerwindowtxtfAddress').getValue(),
                     companyName : Ext.getCmp('customerwindowtxtfCompanyName').getValue(),
                    contactNumber : Ext.getCmp('customertxtfContactNumber').getValue(),
                     mailAddress : Ext.getCmp('customertxtfEmail').getValue(),
                    role : Ext.getCmp('customertxtfRole').getValue(),
                    isActive : checkActive,
                    username : Ext.getCmp('customertxtfUsername').getValue(),
                    password : Ext.getCmp('customertxtfPassword').getValue()
        		});


        Ext.Ajax.request({
        			url : 'createCustomer',
        			method : 'POST',
        			jsonData : Ext.encode(customer.data),
        			success : function(response) {
        				var res = Ext.decode(response.responseText);
        				if(res=='true'){
        					alert('Successfully saved')
        				}else{
        					 alert('Failed to save');
        				}
        			},
        			failure : function(response) {
                        alert('Failed to save');
        			}
        		});
    	}else if(action==='Update'){
    		console.log('Update CUstomer');
    		var modelId = 'layout.model.';
            var checkActive;
            if(Ext.getCmp('customerchkboxActive').getValue()===true){
                checkActive = 1;
            }else{
                checkActive = 0;
            }
            		var customer = Ext.create(modelId + 'CustomerCreationModel', {
            			customerId : Ext.getCmp('customertxtfCustomerId').getValue(),
                        firstname : Ext.getCmp('customertxtfFirstName').getValue(),
                        lastname : Ext.getCmp('customertxtfLastName').getValue(),
                         address : Ext.getCmp('customerwindowtxtfAddress').getValue(),
                         companyName : Ext.getCmp('customerwindowtxtfCompanyName').getValue(),
                        contactNumber : Ext.getCmp('customertxtfContactNumber').getValue(),
                         mailAddress : Ext.getCmp('customertxtfEmail').getValue(),
                        role : Ext.getCmp('customertxtfRole').getValue(),
                        isActive : checkActive,
                        username : Ext.getCmp('customertxtfUsername').getValue(),
                        password : Ext.getCmp('customertxtfPassword').getValue()
            		});


            Ext.Ajax.request({
            			url : 'updateCustomer',
            			method : 'POST',
            			jsonData : Ext.encode(customer.data),
            			success : function(response) {
            				var res = Ext.decode(response.responseText);
            				console.log(res);
            				alert('Successfully Saved');
            			},
            			failure : function(response) {
                            alert('Failed to save');
            			}
            		});
    	}
    },

    init: function(application) {
        this.control({
            "#tabCustomerBtnCreate": {
                click: this.onTabCustomerBtnCreateClick
            },
            "#customerbtnCreate": {
                click: this.onCustomerbtnCreateClick
            },
            "#tabCustomerBtnSearch": {
                click: this.onTabCustomerBtnSearchClick
            },
            "#tabCustomerBtnEdit": {
                click: this.onTabCustomerBtnEditClick
            },
            "#tabCustomerBtnBrowse": {
                click: this.onTabCustomerBtnBrowseClick
            }
        });
    }

});
