import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Book as B } from '../components';

class Home extends Component {
  constructor() {
    super();
    this.state = {
      books: [],
    };
  }

  async componentDidMount() {
    const response = await fetch('http://localhost:3004', { mode: 'cors' });
    const data = await response.json();
    const books = data.data.list;
    this.setState({ books });
  }

  render() {
    const { books } = this.state;
    return (
      <div>
        <Link to={{ pathname: 'book/create' }}>Add book</Link>
        <Wrapper>{books.map(book => <Book book={book} />)}</Wrapper>
      </div>
    );
  }
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 150px 50px;
`;

const Book = styled(B)`
  display: flex;
  align-items: flex-start;
  margin-bottom: 25px;
  width: 25%;
`;

export default Home;
