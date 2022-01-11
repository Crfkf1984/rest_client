package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
@AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private String description;
    private String urowen;
    private String data;
}
