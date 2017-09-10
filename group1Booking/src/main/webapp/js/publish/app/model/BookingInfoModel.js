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
            name: 'BOOKING_NUM',
            type: 'int'
        },
        {
            name: 'SHIPPER_ID',
            type: 'int'
        },
        {
            name: 'CONSIGNEE_ID',
            type: 'int'
        },
        {
            name: 'CONTAINER_NUM',
            type: 'string'
        },
        {
            name: 'CONTAINER_TYPE',
            type: 'string'
        },
        {
            name: 'CARGO_NATURE',
            type: 'string'
        },
        {
            name: 'CARGO_DESCRIPTION',
            type: 'string'
        },
        {
            name: 'GROSS_WEIGHT',
            type: 'float'
        },
        {
            name: 'NET_WEIGHT',
            type: 'float'
        },
        {
            name: 'FROM_CITY',
            type: 'string'
        },
        {
            name: 'TO_CITY',
            type: 'string'
        },
        {
            name: 'CREATED_BY',
            type: 'string'
        },
        {
            name: 'UPDATED_BY',
            type: 'string'
        },
        {
            name: 'UPDATE_DATE',
            type: 'string'
        },
        {
            name: 'IS_ACTIVE',
            type: 'int'
        },
        {
            name: 'GROSS_UNIT',
            type: 'string'
        },
        {
            name: 'NET_UNIT',
            type: 'string'
        },
        {
            name: 'IS_WEIGHT_VALID',
            type: 'string'
        },
        {
            name: 'IS_GOOD_CUSTOMER',
            type: 'string'
        },
        {
            name: 'IS_DOCUMENTS_APPROVED',
            type: 'string'
        }
    ]
});