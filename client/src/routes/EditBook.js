import React, {Component} from 'react';
import API from '../api/Api';
import CreateBook from "./CreateBook";

class EditBook extends CreateBook {
  async componentDidMount() {
    const {bookId} = this.props.match.params;
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

    const bookResponse = await API.getBook(bookId);

    if (bookResponse.ok) {
      const {data} = bookResponse;
      this.setState(prevState => ({
        ...prevState,
        count: data.count,
        cover: data.cover,
        description: data.description,
        id: data.id,
        isbn: data.isbn,
        size: data.size,
        title: data.title,
        year: data.year,
        authors: {...prevState.authors,
          selected: data.authors.map(entity => ({...prevState.authors.loaded.find(arg => arg.key === entity.id), id: entity.id}))},
        publishers: {...prevState.publishers,
          selected: {...prevState.publishers.loaded.find(arg => arg.key === data.publisher.id), id: data.publisher.id}
        },
        categories: {...prevState.categories,
          selected: data.categories.map(entity => ({...prevState.categories.loaded.find(arg => arg.key === entity.id), id: entity.id}))}
      }));
      console.log(this.state);
    } else {
      console.error(categoriesResponse.error);
    }

    this.setState(prevState => ({
      ...prevState,
      loadingComplete: true
    }));
  }

  _getHeaderText() {
    return 'Изменить книгу';
  }

  createNewBook = async () => {
    const response = await API.editBook(this.state.id, this.state);
    const {ok, data, error} = response;
    if (ok) {
      this.props.history.push('/');
      console.log(data);
    } else {
      this.setState({error});
      console.error(error);
    }
  };
}

export default EditBook;
