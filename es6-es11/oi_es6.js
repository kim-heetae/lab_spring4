//Object Initializer
//https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Object_initializer
{
  const person = {
    name : 'hit',
    age : 35
  };
  
  const name = 'hite';
  const age = 35;
  const person2 = {
    name : name,
    age : age
  };
  
  const person3 = {
    name,
    age,
  }
  
  console.log(person);
  console.log(person2);
  console.log(person3);

}