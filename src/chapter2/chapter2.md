# 객체지향 원리

## 추상화

“객체 지향의 추상화는 곧 모델이다”  

추상화란 복잡한 자료, 모듈, 시스템 등으로부터 핵심적인 개념 또는 기능을 간추려 내는 것을 말한다.  
구체적인 사물들간의 공통점을 취하고 차이점을 버리는 일반화를 사용하거나  
중요한 부분을 강조하기 위해 불필요한 세부 사항을 제거함으로써 단순하게 만든다.  
구체적인 개념에 의존하지 않고 추상적 개념에 의존해야 설계를 유연하게 변경할 수 있다. 

## 캡슐화

개념  
객체의 속성 (data field)과 행위 (method) 를 하나로 묶고, 실제 구현 내용을 외부에 감추어 은닉한다. 

아래와 같이 정리할 수 있다.

```java
class Capsule {
    int number;
    
    public Capsule(int number) {
        this.number = number;
    }
    
    public double getHalf() {
        return number / 2;
    }
}


class Main {
    public static void main(String[] args) {
        Capsule capsule = new Capsule(10);
        System.out.println(capsule.getHalf());
    }
}
```

Main 메서드의 입장에서 Capsule 클래스의 getHalf()를 사용할 수 있지만 구현이 어떻게 되어있는지는 알 수 없다.
 

캡슐화를 지키기 위한 규칙중에는 Tell, Don't Ask 라는 원칙이 있다.  
이는 객체와 객체가 협력하는 경우, 다른 객체에게 정보를 요구하지 않고 (객체로부터 받아와서 처리하지 않고) 객체가 처리하도록 시키라는 의미이다. 

어떤 물품의 10% 할인된 금액을 구해야 한다고 생각해 보자. 

만일 데이터를 객체에서 받아와서 처리를 한다면 우리는 비즈니스 로직에 다음과 같은 코드를 추가할 것이다.

```java
public void foo(Goods goods) {
    double discountedPrice = goods.getPrice() * 0.9;
    var(discountedPrice);
}
```

상품의 가격을 가지고 와서 10프로 할인된 가격을 구하고, 다른 로직으로 넘겼다. 즉, 위 코드는 데이터를 객체로부터 받아와서 처리하는 로직을 구현하고 있다.

그렇다면, 만일 10프로 할인된 금액을 다른 로직에서도 사용하게 된다면 어떻게 될까?

아래와 같은 로직이 서비스에서 수백번 필요하다면?

```java
public void foo(Goods goods) {
    double discountedPrice = goods.getPrice() * 0.9;
    var(discountedPrice);
}

public void foo2(Goods goods) {
    double discountedPrice = goods.getPrice() * 0.9;
    var2(discountedPrice);
}

```

데이터를 처리하는 방식의 외부에 드러나지 않는 것은 어떤 면에서 이점이 있을까?

위 예제에서 요구사항이 변경되어 10프로 할인된 금액이 아니라 20프로 할인된 금액으로 로직을 바꿔야 한다고 생각해 보자. 

그렇다면 위와 같이 코드가 작성되었다면, 우리는 도대체 몇줄의 코드를 고쳐야 하는가? IDE의 검색기능을 이용해 편히 고칠 수 있다고 해 보자. 

이번에는 데이터를 객체로부터 받아오는게 아닌, 객체가 처리하도록 코드를 작성하면 어떻게 될까?

```java
class Goods {
    int price = 10000;
    ...
    public int getDiscountedPrice() {
        return price * 0.9;
    }
}

public void foo(Goods goods) {
    double discountedPrice = goods.getDiscountedPrice();
    var(discountedPrice);
}
```

10프로 할인된 금액을 도출하는 로직이 객체 안으로 이동했다. 

그에 따라 foo()에서 할인된 금액을 생성하는 부분도, 비즈니스 로직이 10프로를 할인 하는게 아닌 Goods에게 "메세지를 보내서(메소드를 호출하여)" 데이터를 가지고 있는 Goods가 스스로 처리하도록 소스가 변경되었다.

그렇다면 이제 위에서 말했던 문제들을 다시 적용시켜 보자. 위와 같이 할인된 금액을 사용하는 로직이 수백개가 있고, 요구사항이 20프로를 할인하도록 변경됐다. 우리는 무엇을 바꾸면 되는가? getDiscountedPrice()의 로직을 수정하면 된다. 

데이터를 처리하는 방식이 외부에 드러나는게 아닌, 객체 스스로 처리하도록 하니 모든 문제가 해결됐다.

참고 : 
[https://bperhaps.tistory.com/entry/캡슐화란-무엇인가-어떤-이점이-있는가](https://bperhaps.tistory.com/entry/%EC%BA%A1%EC%8A%90%ED%99%94%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80-%EC%96%B4%EB%96%A4-%EC%9D%B4%EC%A0%90%EC%9D%B4-%EC%9E%88%EB%8A%94%EA%B0%80)

## 일반화 관계

### 일반화는 또 다른 캡슐화

객체지향 프로그래밍 관점에서는 일반화 관계를 상속 관계라 한다. 

속성이나 기능의 재사용만 강조해서 사용하는 경우가 많은데, 일반화는 여러 개체들이 가진 공통된 특성을 부각시켜 하나의 개념이나 법칙으로 성립시키는 과정이라고 볼 수 있다.

변경사항에 유연성 있게 대처하기 위해 일반화 관계를 이용한다. 

외부 세계에 자식 클래스를 캡슐화 (또는 은닉) 하는 개념이 일반화 관계이고,

이 때 캡슐화 개념은 한 클래스 안에 있는 속성 및 연산들의 캡슐화에 한정하지 않고 일반화 관계를 통해 클래스 자체를 캡슐화하는 것으로 확장된다.

서브 클래스 캡슐화는 외부 클라이언트가 개별적인 클래스들과 무관하게 프로그래밍 할 수 있도록  한다.

### 일반화 관계와 위임

일반화 관계를 속성이나 기능의 상속, 재사용을 위해 존재한다고 오해하지만 그것은 사실이 아니다. 

ArrayList

- isEmpty()
- size()
- add()
- remove()

ArrayList 클래스를 상속 받아 Stack 클래스를 만든다고 했을 때, 의도는 ArrayList 클래스에 정의된 메서드들을 사용하려고 한 것이지만 스택과 전혀 관련없는 수많은 연산이나 속성도 같이 상속받게 된다. 

기본적으로 일반화 관계는 ‘is a kind of 관계’ 가 성립되어야 한다. 이를 확인할 수 있는 가장 간단한 방법은 다음 문장이 참인지를 판단하는 것

Stack “is a kind of” ArrayList. 

ArrayList 대신 Stack 을 상용할 수 있는지? 

두 자식 클래스 사이에 “is a kind of” 관계가 성립되지 않는데 상속을 사용하면 불필요한 속성이나 연산을 물려받게 된다.

어떤 클래스의 일부 기능만 재사용하고 싶은 경우 위임을 사용하면 된다.

위임은 자신이 직접 기능을 실행하지 않고 다른 클래스의 객체가 기능을 실행할 수 있도록 하는 것이다.

일반화 관계는 클래스 사이의 관계지만, 위임은 객체 사이의 관계다. 

위임을 사용하여 일반화를 대신하는 과정

1. 자식 클래스에 부모 클래스의 인스턴스를 참조하는 속성을 만든다. 이 속성 필드를 this로 초기화한다.
2. 서브 클래스에 정의된 각 메서드에 1번에서 만든 위임 속성 필드를 참조하도록 변경한다.
3. 서브 클래스에서 일반화 관계 선언을 제거하고 위임 속성 필드에 슈퍼 클래스의 객체를 생성해 대입한다.
4. 서브 클래스에서 사용된 슈퍼클래스의 메서드에도 위임 메서드를 추가한다.

### 집합론 관점으로 본 일반화 관계

상호 배타적인 부분 집합으로 나누는 과정  


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5c402bf3-b5cc-45a6-a1b9-996afcc47ff7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220123T022622Z&X-Amz-Expires=86400&X-Amz-Signature=df664aaa7466a7f0bb0075e23cbb76c0034a6c72629830d9ed780953084bdc44&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">  
  
  

# 

제약 조건 

disjoint : 자식 클래스가 동시에 두 클래스에 속할 수 없다  
complete : 자식 클래스의 객체에 해당하는 부모 클래스의 객체와 부모 클래스의 객체에 해당하는 자식 클래스의 객체가 하나만 존재한다.

특수화는 일반화의 역관계로, 부모 클래스에서 자식 클래스를 추출하는 과정

어떤 속성이나 연관 관계가 특정 자식 클래스에서만 관련이 있고 다른 자식 클래스에서는 관련이 없는 경우 필요함

vip 회원만 할인 쿠폰을 받을 수 있다면 회원을 vip 회원과 일반 회원으로 특수화하는 이유가 됨  
여러 개의 변별자를 사용하여 집합을 부분집합으로 나눌 때 일반화 관계가 완전히 독립적이지 않은 경우, 모든 분류 가능한 조합으로 대응하는 클래스를 만들 수 있음.


<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fc987f50-bb59-40b6-91a5-78bb19adf82f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220123T022716Z&X-Amz-Expires=86400&X-Amz-Signature=d5767192aa30ee703919afbb24b6812a3421620de4d4fd4f67c6eeb78059e86e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">


### 다형성

서로 다른 클래스의 객체가 같은 메시지를 받았을 때 각자의 방식으로 동작하는 능력

여러 종류의 동물이 있는데 talk라는 명령을 내렸을 때 행동하는 방식은 모두 다르다. 

다형성을 사용하면 구체적으로 현재 어떤 클래스 객체가 참조되는지와 무관하게 프로그래밍을 할 수 있다. 

이것이 가능한 이유는 일반화 관계에 있을 때 부모 클래스의 참조 변수가 자식 클래스의 객체를 참조할 수 있기 때문이다. 

### 피터 코드의 상속 규칙

- 자식 클래스와 부모 클래스 사이는 역할 수행 관계가 아니어야 한다.
- 한 클래스의 인스턴스는 다른 서브 클래스의 객체로 변환할 필요가 절대 없어야 한다.
- 자식 클래스가 부모 클래스의 책임을 무시하거나 재정의하지 않고 확장만 수행해야 한다.
- 자식 클래스가 단지 일부 기능을 재사용할 목적으로 유틸리티 역할을 수행하는 클래스를 상속하지 않아야 한다.
- 자식 클래스가 역할, 트랜잭션, 디바이스 등을 특수화 해야한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0d64ad78-f044-41c7-8501-249c3e78c5c8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220123T022803Z&X-Amz-Expires=86400&X-Amz-Signature=6a5fce455dfba0b3cbb51476dc601e603062e7154f26c00926179cce022eb4b5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">


# 
위는 피터 코드의 상속 규칙을 따르고 있는지? 

- 운전자, 회사원 모두 사람이 수행하는 역할 중 하나
- 운전자는 회사원이 될 수 있고, 회사원 역시 운전자가 될 수 있음
- 알 수 없다.
- 기능만 재사용할 목적으로 상속 관계를 표현하는 것은 아니므로 규칙 준수
- 역할, 트랜잭션, 디바이스 특수화 X

⇒ 상속이 아닌 집약 또는 연관관계로 표현해야함 



<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ae0c8d82-147e-4942-b64c-4c3f8f87afc0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220123T014542Z&X-Amz-Expires=86400&X-Amz-Signature=764c1a6ef6e43d73ed36a5f0f393fa9bca1884556df5625a5518b8fdc4058e67&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject" alt=""/>

#  
역할이라는 추상 클래스를 상속받는 구조로 다른 역할이 추가 되어도 사람 클래스는 변경되지 않는다.
여기서 0..1 은 사람의 입장에서 역할이 존재할 수도 혹은 그렇지 않을 수도 있다는 의미이다. 


이를 개방-폐쇄의 원칙이라고 한다. (Open-Closed Principle)