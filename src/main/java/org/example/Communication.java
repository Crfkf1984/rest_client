package org.example;

import org.example.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    private RestTemplate restTemplate;
    private final String URL ="http://localhost:8080/api/todos";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getAllTodo() {
        ResponseEntity<List<Todo>> list = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Todo>>() {});
        List<Todo> todos = list.getBody();
        return todos;
    }

    public Todo getTodo(int id) {
        Todo todos = restTemplate.getForObject(URL + "/" + id, Todo.class);
        return todos;
    }

    public void saveTodo(Todo todos) {
        int id = todos.getId();
        if (id == 0) {
            ResponseEntity<String> list = restTemplate.postForEntity(URL + "/", todos, String.class);
            System.out.println("Работник добавлен!!!" + list.getBody());
       } else {
            restTemplate.put(URL + "/", todos);
            System.out.println("Работник с id " + id + " обновлен!!!");
        }

    }

    public void deleteTodo(int id) {
       restTemplate.delete(URL + "/" + id);
        System.out.println("Дело с " + id + " удаленно!!!");
    }
}
