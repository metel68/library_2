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
      authors: {
        showAddField: true,
        loaded: [],
        selected: [],
        new: '',
      },
      publishers: {
        showAddField: false,
        loaded: [],
        selected: '',
        new: '',
      },
      title: '',
      year: '',
      count: '',
      size: '',
      description: '',
    };
  }

  async componentDidMount() {
    const authorsResponse = await API.getAuthors();
    if (authorsResponse.ok) {
      const { data } = authorsResponse;
      const { authors } = this.state;
      this.setState({ authors: { ...authors, loaded: data } });
    } else {
      console.error(authorsResponse.error);
    }

    const publishersResponse = await API.getPublishers();

    if (publishersResponse.ok) {
      const { data } = publishersResponse;
      this.setState(prevState => ({
        ...prevState,
        publishers: { ...prevState.publishers, loaded: data },
      }));
    } else {
      console.error(publishersResponse.error);
    }
  }

  changeInputValue = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  changeAuthorsArray = (e, data) => {
    const { value } = data;
    const { authors } = this.state;
    const newAuthors = value.map(authorId => ({
      id: authorId,
    }));
    this.setState({ authors: { ...authors, selected: [...authors.selected, ...newAuthors] } });
  };

  addNewAuthor = async e => {
    const { authors } = this.state;
    const response = await API.createNewAuthor(authors.new);
    const { ok, data, error } = response;
    if (ok) {
      const { id, fullName } = data;
      this.setState(prevState => ({
        ...prevState,
        authors: {
          ...prevState.authors,
          loaded: [...prevState.authors.loaded, { key: id, text: fullName, value: id }],
          new: '',
          showAddField: false,
        }, //TODO: Заменить нужным форматом автора из data
      }));
    } else {
      console.error(error);
    }
  };

  addNewPublisher = async e => {
    const { publishers } = this.state;
    const response = await API.createNewPublisher(publishers.new);
    const { ok, data, error } = response;
    if (ok) {
      const { id, name } = data;
      this.setState(prevState => ({
        ...prevState,
        publishers: {
          ...prevState.publishers,
          loaded: [...prevState.publishers.loaded, { key: id, text: name, value: id }],
          new: '',
          showAddField: false,
        },
      }));
    } else {
      console.error(error);
    }
  };

  changeNewPublisherValue = e => {
    const { value } = e.target;
    this.setState(prevState => ({
      ...prevState,
      publishers: { ...prevState.publishers, new: value },
    }));
  };

  changeNewAuthorValue = e => {
    const { value } = e.target;
    this.setState(prevState => ({
      ...prevState,
      authors: { ...prevState.authors, new: value },
    }));
  };

  setPublisherValue = (e, data) => {
    const { value } = data;
    this.setState(prevState => ({
      ...prevState,
      publishers: { ...prevState.publishers, selected: value },
    }));
  };

  NewAuthorForm = () => {
    const { authors } = this.state;
    const { changeNewAuthorValue, addNewAuthor } = this;
    return (
      <Form.Field>
        <Form.Field>
          <label>Добавить автора</label>
          <input
            name="author"
            value={authors.new}
            onChange={changeNewAuthorValue}
            placeholder="Имя автора"
          />
        </Form.Field>
        <Form.Field>
          <Button type="submit" onClick={addNewAuthor}>
            Добавить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  render() {
    const { title, publishers, year, count, size, description, authors } = this.state;
    const {
      changeInputValue,
      changeAuthorsArray,
      addNewAuthor,
      setPublisherValue,
      addNewPublisher,
      NewAuthorForm,
      changeNewPublisherValue,
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
              options={authors.loaded}
              onChange={changeAuthorsArray}
            />
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
            />
          </Form.Field>
          <Form.Field>
            <label>Добавить издательство</label>
            <input
              value={publishers.new}
              name="newPublisher"
              onChange={changeNewPublisherValue}
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
