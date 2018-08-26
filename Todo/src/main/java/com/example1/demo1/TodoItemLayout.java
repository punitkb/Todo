package com.example1.demo1;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;


public class TodoItemLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoItemLayout(Todo todo, TodoChangeListener changeListener) {
      done = new CheckBox();
      text = new TextField();
      text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

      addComponents(done);
      addComponentsAndExpand(text);
      setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

      Binder<Todo> binder = new Binder<>(Todo.class);
      binder.bindInstanceFields(this);
      binder.setBean(todo);

        binder.addValueChangeListener(event -> changeListener.todoChanged(todo));
    }
}
