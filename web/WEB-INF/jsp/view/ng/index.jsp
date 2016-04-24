<html ng-app="myApp">
  <head>
    <title>Form Demo</title>
    <style>body{font-family: "Arial"; background-color: #E2E2DC}</style>
    <style>
      .username.ng-valid {
        background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
        background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
        background-color: yellow;
      }

      .email.ng-valid {
        background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
        background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
        background-color: yellow;
      }
    </style>
  </head>
  <body ng-controller="AppController as ctrl">
    <form ng-submit="ctrl.submit()" name="myForm">
      <input type="text" ng-model="ctrl.user.username" class="username" name="uname" placeholder="Enter your name" required ng-minlength="3"/>
        <span ng-show="myForm.$dirty && myForm.uname.$error.required">This is a required field</span>
        <span ng-show="myForm.$dirty && myForm.uname.$error.minlength">Minimum length required is 4</span>
        <span ng-show="myForm.$dirty && myForm.uname.$invalid">This field is invalid</span><br/><br/>

      <input type="text" ng-model="ctrl.user.address" placeholder="Enter your Address"/><br/><br/>

      <input type="email" ng-model="ctrl.user.email" class="email" name="email" placeholder="Enter your Email" required/>
      <span ng-show="myForm.$dirty && myForm.email.$error.required">This is a required field</span>
      <span ng-show="myForm.$dirty && myForm.email.$invalid">This field is invalid </span><br/><br/>

      <input type="submit" value="Submit" ng-disabled="myForm.$invalid">
    </form>

  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script>
    angular.module('myApp', [])
            .controller('AppController', [function() {
              var self = this;
              self.submit = function() {
                console.log('Form is submitted with following user', self.user);
              }
            }]);
  </script>
  </body>
</html>
