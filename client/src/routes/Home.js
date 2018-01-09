import React, { Component } from 'react';
import styled from 'styled-components';
import { Container, Input, Checkbox as C } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import intersection from 'lodash/intersection';
import { Book as B } from '../components';
import { isAdmin } from '../utils';
import API from '../Api';

class Home extends Component {
  constructor() {
    super();
    this.state = {
      books: [],
      tags: [],
      selectedFilters: [],
    };
  }

  async componentDidMount() {
    const response = await API.getBooks();
    const { data } = response;
    const res = await API.getCategories();
    const tagsData = res.data;
    this.setState({ books: data, tags: tagsData, isAdmin: isAdmin() });
  }

  searchBook = async e => {
    const { value } = e.target;
    const response = await API.searchBooks(value);
    const { data } = response;
    this.setState({ books: data });
  };

  filterBooks = (e, data) => {
    const { name, checked } = data;
    if (checked) {
      this.setState(prevState => ({
        ...prevState,
        selectedFilters: [...prevState.selectedFilters, name],
      }));
    } else {
      this.setState(prevState => ({
        ...prevState,
        selectedFilters: prevState.selectedFilters.filter(filterId => filterId !== name),
      }));
    }
  };

  logout = () => {
    localStorage.setItem('isAuthorized', false);
    localStorage.setItem('isAdmin', false);
    this.props.history.push('/');
  };

  render() {
    const { books, tags, selectedFilters, isAdmin } = this.state;
    const filteredBooks = selectedFilters.length
      ? books.filter(book => {
          const bookCategoriesId = book.categories.map(category => category.id);
          const numberOfIntersections = intersection(selectedFilters, bookCategoriesId).length;
          return numberOfIntersections !== 0;
        })
      : books;
    const { searchBook, filterBooks, logout } = this;
    return (
      <Layout>
        <a href="#" onClick={logout}>
          Выйти
        </a>
        <Wrapper>
          {isAdmin ? <Link to={{ pathname: '/book/create' }}>Добавить книгу</Link> : null}
          <Input icon="search" placeholder="Search..." onChange={searchBook} />
        </Wrapper>
        <Wrapper>
          {tags.map(tag => (
            <Category>
              <Checkbox
                label={{ children: tag.text }}
                name={tag.key}
                type="radio"
                onClick={filterBooks}
              />
            </Category>
          ))}
        </Wrapper>
        <Wrapper>{filteredBooks.map(book => <Book book={book} />)}</Wrapper>
      </Layout>
    );
  }
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-top: 50px;
`;

const Book = styled(B)`
  display: flex;
  align-items: flex-start;
  margin-bottom: 25px;
  width: 33%;
`;

const Layout = styled(Container)`
  margin-top: 50px;
`;

const Category = styled.label`
  display: inline-block;
  margin-right: 0.5em;
  padding: 0.25em;
  padding-right: 15px;
  line-height: 1;
  cursor: pointer;
  color: #4078c0;
  border: 1px solid #e7f2ff;
  border-radius: 3px;
  background-color: #e7f2ff;
`;
const Checkbox = styled(C)`
  color: #4078c0;
`;

const Tag = styled.span`
  padding-right: 0.25em;
  padding-left: 0.25em;
`;

export default Home;
