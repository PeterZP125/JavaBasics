package com.peter.fanxing._01_继承性;

public class InheritFather<K, V> {

}

//不保留父类泛型
//等价于class Son1 extends InheritFather<Object, Object>
class Son1 extends InheritFather{}
//等价于class Son1 extends InheritFather<Object, Object>
class Son11<A,B> extends InheritFather{}

class Son2 extends  InheritFather<Integer,String>{}
class Son21<A,B> extends  InheritFather<Integer,String>{}

//保留父类泛型
class Son3<K,V> extends  InheritFather<K,V>{}
class Son31<A,B,K,V> extends  InheritFather<K,V>{}

class Son4<K> extends InheritFather<K, String>{}
class Son41<K,A> extends InheritFather<K, String>{}


