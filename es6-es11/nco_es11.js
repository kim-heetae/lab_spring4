//Nullish coalescing operator - 널 병합 연산자

{
  {
    const name = 'scott';
    const userName = name || 'Guest';
    console.log(userName);
  }
  {
    const name = null;
    const userName = name || 'Guest';
    console.log(userName);
  }
  {
    const name = '';
    const userName = name || 'Guest';
    console.log(userName);
  }
  {
    const num = 0;
    const message = num || 'Undifinded';
    console.log(message);
  }
  //문제 해결 구간
  {
    const name = '';
    const userName = name ?? 'Guest';
    console.log(`빈 문자열 ==> ${userName}`);
    const num = 0;
    const message = num ?? 'Undifinded';
    console.log(`0 ==> ${message}`);
    
  }
}