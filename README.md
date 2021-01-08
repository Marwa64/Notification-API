# Notification-API
Notification API is a REST API that allows users to send email or sms notifications easily using a variety of ready made templates. The users can also add their own templates to use.

## Access to the API

All requests to the API begin with: 

```shell
https://notification-api64.herokuapp.com
```

## POST Requests and data format

All data is in [JSON](http://json.org) format

* Here is an example of a typical POST request to add a template:
```json
{
    "templateName": "Activation Code",
    "content": "Hello %n ! Thank you for registering at %p1 . Please enter this code %p2 to activate your account",
    "language": "english"
}
```
The placeholder `%n` is replaced by the name, while `%p1` is replaced by placeholder1 and `%p2` is replaced by placeholder2
<br/><br/>

* Here is an example of a typical POST request to send a notification:
```json
{
    "subject": "Test",
    "channel": "email",
    "receiver": "test@gmail.com",
    "name": "user",
    "placeholder1": "p1",
    "placeholder2": "p2",
    "templateName": "name"
}
```


## All Endpoints

Routes | Description
------------ | -------------
`notification/send` | Send a Notification
`notification/get/email` | Gets a list of all the Email Notifications
`notification/get/sms` | Get a list of all the SMS Notifications
`template/create` | Add a Template
`template/get/{id}` | Get a Template
`template/get` | Get All Templates
`template/update?id={id}` | Update a Template
`template/delete/{id}` | Delete a Template

## Developers

* [Marwa Omar](https://github.com/Marwa64)
* [Samar Yassin](https://github.com/samar-yassin)
* [Abd Elhadi Omar](https://github.com/Abd-Elhadi)
