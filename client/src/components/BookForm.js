import React, {Component} from 'react';
import {
  Container,
  Header,
  Form,
  Button,
  Dropdown,
  Input,
  TextArea,
} from 'semantic-ui-react';

class BookForm extends Component {
  NewAuthorForm = () => {
    const {authors, changeNewAuthorValue, addNewAuthor, hideAddField} = this.props;
    return (
      <Form.Field>
        <Form.Field>
          <label>Добавить автора</label>
          <input
            name="author"
            defaultValue={authors.new}
            onChange={changeNewAuthorValue}
            placeholder="Имя автора"
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" onClick={addNewAuthor}>
            Добавить
          </Button>
        </Form.Field>
        <Form.Field>
          <Button type="button" name="authors" onClick={hideAddField}>
            Отменить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  NewCategoryForm = () => {
    const {categories, changeNewCategoryValue, addNewCategory, hideAddField} = this.props;
    return (
      <Form.Field>
        <Form.Field>
          <label>Добавить категорию</label>
          <input
            name="category"
            defaultValue={categories.new}
            onChange={changeNewCategoryValue}
            placeholder="Название категории"
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" onClick={addNewCategory}>
            Добавить
          </Button>
        </Form.Field>
        <Form.Field>
          <Button type="button" name="categories" onClick={hideAddField}>
            Отменить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  NewPublisherForm = () => {
    const {publishers, changeNewPublisherValue, addNewPublisher, hideAddField} = this.props;
    return (
      <Form.Field>
        <Form.Field>
          <label>Добавить издательство</label>
          <input
            defaultValue={publishers.new}
            name="newPublisher"
            onChange={changeNewPublisherValue}
            placeholder="Название издательства"
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" onClick={addNewPublisher}>
            Добавить
          </Button>
        </Form.Field>
        <Form.Field>
          <Button type="button" name="publishers" onClick={hideAddField}>
            Отменить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  render() {
    const {
      title,
      publishers,
      year,
      count,
      size,
      description,
      authors,
      categories,
      cover,
      isbn,
      changeInputValue,
      changeAuthorsArray,
      setPublisherValue,
      changeCategoriesArray,
      createNewBook,
      showAddField
    } = this.props;

    const {
      NewAuthorForm,
      NewCategoryForm,
      NewPublisherForm
    } = this;

    return (
      <Form onSubmit={createNewBook}>
        <Form.Field>
          <label>Название</label>
          <input
            type="text"
            name="title"
            onChange={changeInputValue}
            value={title}
            placeholder="Название книги"
            required
          />
        </Form.Field>
        <Form.Field>
          <label>Выбрать категории книги</label>
          <Dropdown
            placeholder="Выбрать категории"
            fluid
            multiple
            selection
            options={categories.loaded}
            onChange={changeCategoriesArray}
            defaultValue={categories.selected.map(cat => cat.value)}
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" name="categories" onClick={showAddField}>
            +
          </Button>
        </Form.Field>
        {categories.showAddField ? NewCategoryForm() : null}
        <Form.Field>
          <label>Выбрать авторов книги</label>
          <Dropdown
            placeholder="Выбрать авторов"
            fluid
            multiple
            selection
            options={authors.loaded}
            onChange={changeAuthorsArray}
            defaultValue={(authors.selected.map(author => author.value))}
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" name="authors" onClick={showAddField}>
            +
          </Button>
        </Form.Field>
        {authors.showAddField ? NewAuthorForm() : null}
        <Form.Field>
          <label>Выбрать издательство</label>
          <Dropdown
            placeholder="Выбрать издательство"
            fluid
            selection
            options={publishers.loaded}
            onChange={setPublisherValue}
            defaultValue={publishers.selected.value}
          />
        </Form.Field>
        <Form.Field>
          <Button type="button" name="publishers" onClick={showAddField}>
            +
          </Button>
        </Form.Field>
        {publishers.showAddField ? NewPublisherForm() : null}
        <Form.Field>
          <label>Введите год издания</label>
          <input type="number" value={year} name="year" onChange={changeInputValue} placeholder="Год издания" min="0" max="2100" />
        </Form.Field>
        <Form.Field>
          <label>Вставьте ссылку на картинку обложки книги</label>
          <input type="url"
                 value={cover}
                 name="cover"
                 onChange={changeInputValue}
                 placeholder="ссылка на обложку"
                 required
          />
        </Form.Field>
        <Form.Field>
          <label>Колличество книг на складе</label>
          <input type="number"
                 name="count"
                 onChange={changeInputValue}
                 value={count}
                 placeholder="Колличество книг на складе"
                 required
                 min="0" max="99999"
          />
        </Form.Field>
        <Form.Field>
          <label>ISBN код</label>
          <input type="text" name="isbn" onChange={changeInputValue} value={isbn} placeholder="ISBN код"/>
        </Form.Field>
        <Form.Field>
          <label>Колличество страниц в книге</label>
          <Input type="number"
                 value={size}
                 label={{basic: true, content: 'страниц'}}
                 labelPosition="right"
                 placeholder="Введите колличество страниц в книге"
                 name="size"
                 onChange={changeInputValue}
                 required
                 min="0" max="99999"
          />
        </Form.Field>
        <Form.Field>
          <label>Описание книги</label>
          <TextArea
            onChange={changeInputValue}
            value={description}
            name="description"
            placeholder="Tell us more"
            style={{minHeight: 100}}
          />
        </Form.Field>
        <Button type="submit">
          Submit
        </Button>
      </Form>
    );
  }
}

export default BookForm;
