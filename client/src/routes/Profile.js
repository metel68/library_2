import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Container, Divider, Header } from 'semantic-ui-react';
import UserAPI from '../api/user';
import { Image, Title, Favorites } from '../components';

class Book extends Component {
  constructor() {
    super();
    this.state = {
      user: {
        username: 'loading...',
        favorites: [],
      },
    };
  }

  async componentDidMount() {
    const userId = localStorage.getItem('userId');
    const response = await UserAPI.getUser(userId);
    const { data } = response;
    this.setState({ user: data });
  }

  render() {
    const { username, favorites, isAdmin } = this.state.user;
    // const { cover, title, authors, isbn, publisher, year, size, description } = this.state.book;
    return (
      <Layout table>
        <InfoRow>
          <Link to={{ pathname: '/' }}>Назад</Link>
        </InfoRow>
        <Header>Профиль { username }</Header>

        <Favorites books={ favorites } />
        <Divider />
      </Layout>
    );
  }
}

const RowTitle = styled.span`
  color: #888;
`;

const RowContent = styled.span`
  color: #000;
`;

const InfoRow = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const BookInfo = styled.div`
  display: flex;
  flex-direction: column;
`;

const Layout = styled(Container)`
  margin-top: 50px;
  margin-bottom: 150px;
`;

const BookWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 50px;
`;

const BookTitle = styled.div`
  display: block;
  margin-left: 80px;
`;

export default Book;
