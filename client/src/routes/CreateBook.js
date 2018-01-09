import React, { Component } from 'react';
import { Container, Header, Form, Button, Dropdown, Input, TextArea } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Author from '../components/Author';
import API from '../Api';
// private int id;
// private String isbn;
// private String title;
// private List<Author> authors = new ArrayList<>();
// private List<Category> cateries = new ArrayList<>()
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
        showAddField: false,
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
      categories: {
        showAddField: false,
        loaded: [],
        selected: [],
        new: '',
      },
      title: '',
      year: '',
      count: '',
      size: '',
      description: '',
      cover: '',
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

    const categoriesResponse = await API.getCategories();

    if (categoriesResponse.ok) {
      const { data } = categoriesResponse;
      this.setState(prevState => ({
        ...prevState,
        categories: { ...prevState.categories, loaded: data },
      }));
    } else {
      console.error(categoriesResponse.error);
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
    this.setState({ authors: { ...authors, selected: newAuthors } });
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
      publishers: { ...prevState.publishers, selected: { id: value } },
    }));
  };

  changeNewCategoryValue = e => {
    const { value } = e.target;
    this.setState(prevState => ({
      ...prevState,
      categories: { ...prevState.categories, new: value },
    }));
  };

  changeCategoriesArray = (e, data) => {
    const { value } = data;
    const { categories } = this.state;
    const newCategories = value.map(categorieId => ({
      id: categorieId,
    }));
    this.setState({
      categories: { ...categories, selected: newCategories },
    });
  };

  addNewCategory = async () => {
    const { categories } = this.state;
    const response = await API.createNewCategory(categories.new);
    const { ok, data, error } = response;
    if (ok) {
      const { id, name } = data;
      this.setState(prevState => ({
        ...prevState,
        categories: {
          ...prevState.categories,
          loaded: [...prevState.categories.loaded, { key: id, text: name, value: id }],
          new: '',
          showAddField: false,
        },
      }));
    } else {
      console.error(error);
    }
  };

  createNewBook = async () => {
    const response = await API.createBook(this.state);
    const { ok, data, error } = response;
    if (ok) {
      this.props.history.push('/');
      console.log(data);
    } else {
      console.error(error);
    }
  };

  showAddField = e => {
    const { name } = e.target;
    this.setState(prevState => ({
      ...prevState,
      [name]: { ...prevState[name], showAddField: true },
    }));
  };

  hideAddField = e => {
    const { name } = e.target;
    this.setState(prevState => ({
      ...prevState,
      [name]: { ...prevState[name], showAddField: false },
    }));
  };

  NewAuthorForm = () => {
    const { authors } = this.state;
    const { changeNewAuthorValue, addNewAuthor, hideAddField } = this;
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
        <Form.Field>
          <Button type="submit" name="authors" onClick={hideAddField}>
            Отменить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  NewCategoryForm = () => {
    const { categories } = this.state;
    const { changeNewCategoryValue, addNewCategory, hideAddField } = this;
    return (
      <Form.Field>
        <Form.Field>
          <label>Добавить категорию</label>
          <input
            name="author"
            value={categories.new}
            onChange={changeNewCategoryValue}
            placeholder="Название категории"
          />
        </Form.Field>
        <Form.Field>
          <Button type="submit" onClick={addNewCategory}>
            Добавить
          </Button>
        </Form.Field>
        <Form.Field>
          <Button type="submit" name="categories" onClick={hideAddField}>
            Отменить
          </Button>
        </Form.Field>
      </Form.Field>
    );
  };

  NewPublisherForm = () => {
    const { publishers } = this.state;
    const { changeNewPublisherValue, addNewPublisher, hideAddField } = this;
    return (
      <Form.Field>
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
          <Button type="submit" name="publishers" onClick={hideAddField}>
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
    } = this.state;
    const {
      changeInputValue,
      changeAuthorsArray,
      addNewAuthor,
      setPublisherValue,
      addNewPublisher,
      NewAuthorForm,
      NewCategoryForm,
      NewPublisherForm,
      changeNewPublisherValue,
      changeCategoriesArray,
      createNewBook,
      showAddField,
    } = this;

    return (
      <Wrapper text>
        <Link to={{ pathname: '/' }}>Назад</Link>
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
            <label>Выбрать категории книги</label>
            <Dropdown
              placeholder="Выбрать категории"
              fluid
              multiple
              selection
              options={categories.loaded}
              onChange={changeCategoriesArray}
            />
          </Form.Field>
          <Form.Field>
            <Button type="submit" name="categories" onClick={showAddField}>
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
            />
          </Form.Field>
          <Form.Field>
            <Button type="submit" name="authors" onClick={showAddField}>
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
            />
          </Form.Field>
          <Form.Field>
            <Button type="submit" name="publishers" onClick={showAddField}>
              +
            </Button>
          </Form.Field>
          {publishers.showAddField ? NewPublisherForm() : null}
          <Form.Field>
            <label>Введите год издания</label>
            <input value={year} name="year" onChange={changeInputValue} placeholder="Год издания" />
          </Form.Field>
          <Form.Field>
            <label>Вставьте ссылку на картинку обложки книги</label>
            <input
              value={cover}
              name="cover"
              onChange={changeInputValue}
              placeholder="ссылка на обложку"
            />
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
            <label>ISBN код</label>
            <input name="isbn" onChange={changeInputValue} value={isbn} placeholder="ISBN код" />
          </Form.Field>
          <Form.Field>
            <label>Колличество страниц в книге</label>
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
          <Button type="submit" onClick={createNewBook}>
            Submit
          </Button>
        </Form>
      </Wrapper>
    );
  }
}

const Wrapper = styled(Container)`
  margin-top: 50px;
  margin-bottom: 50px;
`;

export default CreateBook;
