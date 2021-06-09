//Default Parameters

{
  function print(msg){
    if(msg == null){
      msg = 'default message';
    }
    console.log(msg);
  }
  print('hello');
  print();
  {
    function print(msg = 'default msg'){
      console.log(msg);
    }
    print('hi');
    print();
  }
}