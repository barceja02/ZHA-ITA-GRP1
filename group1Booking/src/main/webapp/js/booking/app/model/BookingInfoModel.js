/*
 * File: app/model/BookingInfoModel.js
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

Ext.define('layout.model.BookingInfoModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'bookingNum',
            type: 'int'
        },
        {
            name: 'shipperId',
            type: 'int'
        },
        {
            name: 'consigneeId',
            type: 'int'
        },
        {
            name: 'containerNumber',
            type: 'string'
        },
        {
            name: 'containerType',
            type: 'string'
        },
        {
            name: 'cargoNature',
            type: 'string'
        },
        {
            name: 'cargoDescrpiption',
            type: 'string'
        },
        {
            name: 'grossWeight',
            type: 'int'
        },
        {
            name: 'netWeight',
            type: 'int'
        },
        {
            name: 'fromCity',
            type: 'string'
        },
        {
            name: 'toCity',
            type: 'string'
        },
        {
            name: 'createdBy',
            type: 'string'
        },
        {
            name: 'createDate',
            type: 'string'
        },
        {
            name: 'updatedBy',
            type: 'string'
        },
        {
            name: 'updateDate',
            type: 'string'
        },
        {
            name: 'isActive',
            type: 'int'
        },
        {
            name: 'grossUnit',
            type: 'string'
        },
        {
            name: 'netUnit',
            type: 'string'
        },
        {
            name: 'isWeightValid',
            type: 'string'
        },
        {
            name: 'isCustomerGood',
            type: 'string'
        },
        {
            name: 'isDocumentApproved',
            type: 'string'
        },
        {
            name: 'isConfirmed',
            type: 'string'
        }
    ]
});