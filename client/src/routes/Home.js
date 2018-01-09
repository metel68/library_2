import React, { Component } from 'react';
import styled from 'styled-components';
import { Container } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import { Book as B } from '../components';
import API from '../Api';

class Home extends Component {
  constructor() {
    super();
    this.state = {
      books: [],
    };
  }

  async componentDidMount() {
    const response = await API.getBooks();
    const { data } = response;
    this.setState({ books: data });
  }

  render() {
    const { books } = this.state;
    return (
      <Layout>
        <Link to={{ pathname: 'book/create' }}>Добавить книгу</Link>
        <Wrapper>{books.map(book => <Book book={book} />)}</Wrapper>
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
  width: 25%;
`;

const Layout = styled(Container)`
  margin-top: 50px;
`;

export default Home;
