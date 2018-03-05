describe( 'AppCtrl', function() {
  describe( 'isCurrentUrl', function() {
    var $location, $scope;

    beforeEach( module( 'activePortal' ) );

    beforeEach( inject( function( $controller, _$location_, $rootScope ) {
      $location = _$location_;
      $scope = $rootScope.$new();
    }));

    it( 'should pass a dummy test', inject( function() {
      expect( $scope ).toBeTruthy();
    }));
  });
});
