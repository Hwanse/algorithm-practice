package study.algorithm.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashTablePracticeTest {

  @Test
  public void hashTablePracticeTest() {
    HashTablePractice hashTable = new HashTablePractice(10);
    hashTable.put("hwanse", "1");
    hashTable.put("hs", "2");
    hashTable.put("sk", "3");
    hashTable.put("hw", "4");
    assertEquals("1", hashTable.get("hwanse"));
    assertEquals("2", hashTable.get("hs"));
    assertEquals("3", hashTable.get("sk"));
    assertEquals("4", hashTable.get("hw"));
    assertEquals("Not Found", hashTable.get("sssss"));

    hashTable.put("hwanse", "hwanse");
    assertEquals("hwanse", "hwanse");
  }

}