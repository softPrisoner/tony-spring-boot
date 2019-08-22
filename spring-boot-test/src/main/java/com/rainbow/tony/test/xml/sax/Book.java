package com.rainbow.tony.test.xml.sax;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Book {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String price;
}
