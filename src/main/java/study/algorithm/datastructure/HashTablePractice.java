package study.algorithm.datastructure;

import java.util.LinkedList;

/**
 * Hash 테이블 구현 연습
 * 1. 입력받은 Key 값으로 해시 코드를 만든다. F(key)
 *    <= 이때 해싱 알고리즘은 동일하니 key 값이 값으면 같은 해시 코드 값이 나온다.
 * 2. 해시코드를 배열의 사이즈로 나눈 값을 배열의 index 값으로 사용한다.
 * 3. 이 때 동일한 key 값이 들어오면 같은 배열방에 들어오게 되는 것이고 해당 방이 가득찰 수도 있다.
 *    따라서 해당 방에 LinkedList 가 있고 LinkedList 에 새로운 값을 추가함.
 *
 * - 충돌(Collision)
 *  : 동일한 해시 값, 배열 index 가지게 될 때를 '충돌'이라고 표현
 * 1. 해시 코드를 만들어내는 해싱 알고리즘이 아무리 좋아도 다른 '키'값이어도 동일한 해시 코드 값이
 *    나올 수 있다.
 * 2. 서로 다른 해시 코드인데도 배열의 크기가 한정되어 있으니 같은 배열 방이 나오는 경우도 있다.
*/
public class HashTablePractice {

  class Node {
    String key;
    String value;

    public Node(String key, String value) {
      this.key = key;
      this.value = value;
    }
    String getValue() {
      return value;
    }
    void setValue(String value) {
      this.value = value;
    }
  }

  LinkedList<Node>[] data;

  HashTablePractice(int size) {
    this.data = new LinkedList[size];
  }

  int getHashCode(String key) {
    int hashcode = 0;
    for (char c : key.toCharArray()) {
      hashcode += c;
    }
    return hashcode;
  }

  int convertToIndex(int hashcode) {
    return hashcode % data.length;
  }

  Node searchKey(LinkedList<Node> list, String key) {
    if (list == null) return null;
    for (Node node : list) {
      if (node.key.equals(key)) {
        return node;
      }
    }
    return null;
  }

  void put(String key, String value) {
    int hashcode = getHashCode(key);
    int index = convertToIndex(hashcode);
    LinkedList<Node> list = data[index];
    if (list == null) {
      list = new LinkedList<>();
      data[index] = list;
    }
    Node node = searchKey(list, key);
    if (node == null) {
      list.addLast(new Node(key, value));
    } else {
      node.setValue(value);;
    }
  }

  String get(String key) {
    int hashcode = getHashCode(key);
    int index = convertToIndex(hashcode);
    LinkedList<Node> list = data[index];
    Node node = searchKey(list, key);

    return node == null ? "Not Found" : node.getValue();
  }

}
