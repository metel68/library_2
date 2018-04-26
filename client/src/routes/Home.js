import React, { Component } from 'react';
import styled from 'styled-components';
import {Checkbox as C, Input} from 'semantic-ui-react';
import intersection from 'lodash/intersection';
import { Book as B } from '../components';
import API from '../api/Api';
import SiteContainer from "../components/SiteContainer";

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
    this.setState({ books: data, tags: tagsData });
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
        selectedFilters: [...prevState.selectedFilters, Number(name)],
      }));
    } else {
      this.setState(prevState => ({
        ...prevState,
        selectedFilters: prevState.selectedFilters.filter(filterId => filterId !== Number(name)),
      }));
    }
  };

  render() {
    const { books, tags, selectedFilters } = this.state;
    const filteredBooks = selectedFilters.length
      ? books.filter(book => {
          const bookCategoriesId = book.categories.map(category => category.id);
          const numberOfIntersections = intersection(selectedFilters, bookCategoriesId).length;
          return numberOfIntersections !== 0;
        })
      : books;
    const { searchBook, filterBooks } = this;
    return (
      <SiteContainer>
        <Wrapper>
          <Input icon="search" placeholder="Search..." onChange={searchBook} />
        </Wrapper>
        <Wrapper>
          {tags.map(tag => (
            <Category key={tag.key}>
              <Checkbox
                label={{ children: tag.text }}
                name={tag.key.toString()}
                type="radio"
                onClick={filterBooks}
              />
            </Category>
          ))}
        </Wrapper>
        <Wrapper>{filteredBooks.map(book => <Book key={book.id} book={book}/>)}</Wrapper>
      </SiteContainer>
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

const Category = styled.label`
  display: inline-block;
  margin: 0.5em;
  padding: 0.25em;
  padding-right: 15px;
  line-height: 1;
  cursor: pointer;
  color: #4078c0;
  border: 1px solid #e7f2ff;
  border-radius: 3px;
  background-color: #e7f2ff;
  width: 23%;
  text-align: center;
`;
const Checkbox = styled(C)`
  color: #4078c0;
`;

const Tag = styled.span`
  padding-right: 0.25em;
  padding-left: 0.25em;
`;

export default Home;
