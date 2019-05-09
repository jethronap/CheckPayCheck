$(function(){
  
    function toggleView(){
      $('.login').toggleClass('is-active');
      $('.register').toggleClass('is-active');
      $('.sign-up-toggle').toggleClass('is-active');
      $('.login-toggle').toggleClass('is-active');
    }
    
    function slideElements(prop){
      $(prop.showEle).removeClass(prop.removeShowClass);
      $(prop.showEle).addClass(prop.addShowClass);
      $(prop.hideEle).removeClass(prop.removeHideClass);
      $(prop.hideEle).addClass(prop.addHideClass);
    }
    
    $('.sign-up-toggle a').on('click',function(){
      toggleView();
      $('.login-view-toggle').addClass('move-top');
      $('.login-view-toggle').removeClass('move-bottom');
      slideElements({
        showEle: '.register',
        removeShowClass: 'down',
        addShowClass: 'pull-up',
        hideEle: '.login',
        addHideClass: 'up',
        removeHideClass: 'push-down'
      });
    });
    
    $('.login-toggle a').on('click',function(){
      toggleView();
      $('.login-view-toggle').addClass('move-bottom');
      $('.login-view-toggle').removeClass('move-top');
      slideElements({
        showEle: '.login',
        removeShowClass: 'up',
        addShowClass: 'push-down',
        hideEle: '.register',
        addHideClass: 'down',
        removeHideClass: 'pull-up'
      });
    });
    
  });