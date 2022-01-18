package com.jjangchen.todolistbackend;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.entity.TodoAttach;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.repository.TodoAccountRepository;
import com.jjangchen.todolistbackend.repository.TodoAttachRepository;
import com.jjangchen.todolistbackend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
/**
 * 테스트용도
 */
public class initComp implements ApplicationRunner {
    private final TodoRepository todoRepository;
    private final TodoAttachRepository todoAttachRepository;
    private final TodoAccountRepository accountRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        TodoAccount account = new TodoAccount("jjang");
        TodoAccount acccount2 = new TodoAccount("jjangchen");
        account = accountRepository.save(account);
        acccount2 = accountRepository.save(acccount2);
        Todo todo = Todo.builder()
                .content("lalalalala")
                .todoAccount(account)
                .build();
        Todo todo2 = Todo.builder()
                .content("kakakakaka")
                .todoAccount(account)
                .build();

        Todo todo3 = Todo.builder()
                .content("hahahah")
                .todoAccount(acccount2)
                .build();

        todo = todoRepository.save(todo);
        todo2 = todoRepository.save(todo2);
        todo3 = todoRepository.save(todo3);

        TodoAttach todoAttach = new TodoAttach("aaaaassssss", todo);
        TodoAttach todoAttach2 = new TodoAttach("bbbbbbb", todo);

        todoAttachRepository.save(todoAttach);
        todoAttachRepository.save(todoAttach2);
    }
}
