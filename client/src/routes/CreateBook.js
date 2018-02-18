import React, { Component } from 'react';

import API from '../api/Api';
import BookForm from "../components/BookForm";

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
      isbn: '',
      title: '',
      year: '',
      count: '',
      size: '',
      description: '',
      cover: '',
      error: '',
      loadingComplete: false,
    };
  }

  async componentDidMount() {
    const authorsResponse = await API.getAuthors();
    if (authorsResponse.ok) {
      const {data} = authorsResponse;
      const {authors} = this.state;
      this.setState({authors: {...authors, loaded: data}});
    } else {
      console.error(authorsResponse.error);
    }

    const publishersResponse = await API.getPublishers();

    if (publishersResponse.ok) {
      const {data} = publishersResponse;
      this.setState(prevState => ({
        ...prevState,
        publishers: {...prevState.publishers, loaded: data},
      }));
    } else {
      console.error(publishersResponse.error);
    }

    const categoriesResponse = await API.getCategories();

    if (categoriesResponse.ok) {
      const {data} = categoriesResponse;
      this.setState(prevState => ({
        ...prevState,
        categories: {...prevState.categories, loaded: data},
      }));
    } else {
      console.error(categoriesResponse.error);
    }

    this.setState(prevState => ({
      ...prevState,
      loadingComplete: true
    }));
  }

  changeInputValue = e => {
    const {name, value} = e.target;
    this.setState({[name]: value});
  };

  changeAuthorsArray = (e, data) => {
    const {value} = data;
    const {authors} = this.state;
    const newAuthors = value.map(authorId => ({
      id: authorId,
    }));
    this.setState({authors: {...authors, selected: newAuthors}});
  };

  addNewAuthor = async e => {
    const {authors} = this.state;
    const response = await API.createNewAuthor(authors.new);
    const {ok, data, error} = response;
    if (ok) {
      const {id, fullName} = data;
      this.setState(prevState => ({
        ...prevState,
        authors: {
          ...prevState.authors,
          loaded: [...prevState.authors.loaded, {key: id, text: fullName, value: id}],
          new: '',
          showAddField: false,
        }, //TODO: Заменить нужным форматом автора из data
      }));
    } else {
      console.error(error);
    }
  };

  addNewPublisher = async e => {
    const {publishers} = this.state;
    const response = await API.createNewPublisher(publishers.new);
    const {ok, data, error} = response;
    if (ok) {
      const {id, name} = data;
      this.setState(prevState => ({
        ...prevState,
        publishers: {
          ...prevState.publishers,
          loaded: [...prevState.publishers.loaded, {key: id, text: name, value: id}],
          new: '',
          showAddField: false,
        },
      }));
    } else {
      console.error(error);
    }
  };

  changeNewPublisherValue = e => {
    const {value} = e.target;
    this.setState(prevState => ({
      ...prevState,
      publishers: {...prevState.publishers, new: value},
    }));
  };

  changeNewAuthorValue = e => {
    const {value} = e.target;
    this.setState(prevState => ({
      ...prevState,
      authors: {...prevState.authors, new: value},
    }));
  };

  setPublisherValue = (e, data) => {
    const {value} = data;
    this.setState(prevState => ({
      ...prevState,
      publishers: {...prevState.publishers, selected: {id: value}},
    }));
  };

  changeNewCategoryValue = e => {
    const {value} = e.target;
    this.setState(prevState => ({
      ...prevState,
      categories: {...prevState.categories, new: value},
    }));
  };

  changeCategoriesArray = (e, data) => {
    const {value} = data;
    const {categories} = this.state;
    const newCategories = value.map(categorieId => ({
      id: categorieId,
    }));
    this.setState({
      categories: {...categories, selected: newCategories},
    });
  };

  addNewCategory = async () => {
    const {categories} = this.state;
    const response = await API.createNewCategory(categories.new);
    const {ok, data, error} = response;
    if (ok) {
      const {id, name} = data;
      this.setState(prevState => ({
        ...prevState,
        categories: {
          ...prevState.categories,
          loaded: [...prevState.categories.loaded, {key: id, text: name, value: id}],
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
    const {ok, data, error} = response;
    if (ok) {
      this.props.history.push('/');
      console.log(data);
    } else {
      this.setState({error});
      console.error(error);
    }
  };

  showAddField = e => {
    const {name} = e.target;
    this.setState(prevState => ({
      ...prevState,
      [name]: {...prevState[name], showAddField: true},
    }));
  };

  hideAddField = e => {
    const {name} = e.target;
    this.setState(prevState => ({
      ...prevState,
      [name]: {...prevState[name], showAddField: false},
    }));
  };

  render() {
    const {
      changeInputValue,
      changeAuthorsArray,
      addNewAuthor,
      setPublisherValue,
      addNewPublisher,
      changeNewPublisherValue,
      changeCategoriesArray,
      createNewBook,
      showAddField,
      hideAddField
    } = this;

    const {
      loadingComplete,
      ...state
    } = this.state;

    if (loadingComplete) {
      return (
        <BookForm {...state}
                  changeInputValue={changeInputValue}
                  changeAuthorsArray={changeAuthorsArray}
                  addNewAuthor={addNewAuthor}
                  setPublisherValue={setPublisherValue}
                  addNewPublisher={addNewPublisher}
                  changeNewPublisherValue={changeNewPublisherValue}
                  changeCategoriesArray={changeCategoriesArray}
                  createNewBook={createNewBook}
                  showAddField={showAddField}
                  hideAddField={hideAddField}
        />
      )
    } else {
      return null;
    }
  }
}

export default CreateBook;
