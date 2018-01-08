import React, { Component } from 'react';
import { Container, Header, Form, Button, Dropdown, Input, TextArea } from 'semantic-ui-react';
import Author from '../components/Author';
import API from '../Api';
// private int id;
// private String isbn;
// private String title;
// private List<Author> authors = new ArrayList<>();
// private Publisher publisher;
// private int year;
// private int count;
// private int size;
// private String description;
// private Date addedAt;
class CreateBook extends Component {
  constructor() {
    super();
    this.state = {
      title: '',
      authors: [],
      publishers: [],
      publisher: '',
      year: '',
      count: '',
      size: '',
      description: '',
      author: '',
      newPublisher: '',
    };
  }

  changeInputValue = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  changeAuthorsArray = (e, data) => {
    const { value } = data;
    this.setState({ authors: value });
  };

  addNewAuthor = async () => {
    const { author } = this.state;
    const response = await API.createNewAuthor(author);
    console.log(response);
    return response;
  };

  addNewPublisher = async () => {
    const { newPublisher } = this.state;
    const response = await API.createNewPublisher(newPublisher);
    console.log(response);
    return response;
  };

  setPublisherValue = (e, data) => {
    const { value } = data;
    this.setState({ publisher: value });
  };

  render() {
    const {
      title,
      publisher,
      year,
      count,
      size,
      description,
      author,
      newPublisher,
      authors,
      publishers,
    } = this.state;
    const {
      changeInputValue,
      changeAuthorsArray,
      addNewAuthor,
      setPublisherValue,
      addNewPublisher,
    } = this;
    return (
      <Container text>
        <Header>Добавить книгу</Header>
        <Form>
          <Form.Field>
            <label>Название</label>
            <input
              name="title"
              onChange={changeInputValue}
              value={title}
              placeholder="Название книги"
            />
          </Form.Field>
          <Form.Field>
            <label>Выбрать авторов книги</label>
            <Dropdown
              placeholder="Выбрать авторов"
              fluid
              multiple
              selection
              options={authors}
              onChange={changeAuthorsArray}
            />
          </Form.Field>
          <Form.Field>
            <label>Добавить автора</label>
            <input
              value={author}
              name="author"
              onChange={changeInputValue}
              placeholder="Имя автора"
            />
          </Form.Field>
          <Form.Field>
            <Button type="submit" onClick={addNewAuthor}>
              Добавить
            </Button>
          </Form.Field>
          <Form.Field>
            <label>Выбрать издательство</label>
            <Dropdown
              placeholder="Выбрать издательство"
              fluid
              selection
              options={publishers}
              onChange={setPublisherValue}
            />
          </Form.Field>
          <Form.Field>
            <label>Добавить издательство</label>
            <input
              value={newPublisher}
              name="newPublisher"
              onChange={changeInputValue}
              placeholder="Название издательства"
            />
          </Form.Field>
          <Form.Field>
            <Button type="submit" onClick={addNewPublisher}>
              Добавить
            </Button>
          </Form.Field>
          <Form.Field>
            <label>Введите год издания</label>
            <input value={year} name="year" onChange={changeInputValue} placeholder="Год издания" />
          </Form.Field>
          <Form.Field>
            <label>Колличество книг на складе</label>
            <input
              name="count"
              onChange={changeInputValue}
              value={count}
              placeholder="Колличество книг на складе"
            />
          </Form.Field>
          <Form.Field>
            <label>Колличество книг на складе</label>
            <Input
              value={size}
              label={{ basic: true, content: 'страниц' }}
              labelPosition="right"
              placeholder="Введите колличество страниц в книге"
              name="size"
              onChange={changeInputValue}
            />
          </Form.Field>
          <Form.Field>
            <label>Описание книги</label>
            <TextArea
              onChange={changeInputValue}
              value={description}
              name="description"
              placeholder="Tell us more"
              style={{ minHeight: 100 }}
            />
          </Form.Field>
          <Button type="submit">Submit</Button>
        </Form>
      </Container>
    );
  }
}

export default CreateBook;
