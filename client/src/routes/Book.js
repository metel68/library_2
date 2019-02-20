import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Divider, Header } from 'semantic-ui-react';
import API from '../api/Api';
import FavAPI from '../api/favs';
import UserAPI from '../api/user';
import { Image, Title, Author } from '../components';
import { isAdmin, isManager } from '../utils';
import SiteContainer from "../components/SiteContainer";
import moment from "moment-with-locales-es6";

function FavLink({inFavs, count, addFav, date}) {
  moment.locale('ru');

  const offset = (moment.duration((moment().utc()).diff(moment.parseZone(date).utc()))).humanize();

  if (inFavs) {
    return (<span>Книга на руках {offset}</span>);
  }
  if (count < 1) {
    return '';
  }
  return (<a href="#" id="addFav" onClick={addFav}>Добавить в заявку</a>);
}

class Book extends Component {
  constructor() {
    super();
    this.state = {
      book: {},
    };
  }

  async componentDidMount() {
    const { bookId } = this.props.match.params;
    const userId = localStorage.getItem('userId');
    const response = await API.getBook(bookId);
    const { data } = response;
    this.setState({ book: data });

    const userResponse = await UserAPI.getUser(userId);
    const favCountResponse = await FavAPI.countFav(bookId);

    const favorite = userResponse.data.favorites.find((fav) => fav.id == bookId);

    const date = favorite && favorite.date;

    this.setState({ inFavs: !!favorite, date, favCount: favCountResponse.data });
  }

  deleteBook = async () => {
    const { book } = this.state;
    const response = API.deleteBook(book.id);
    this.props.history.push('/');
  };

  addFav = async () => {
    const {book} = this.state;
    const userId = localStorage.getItem('userId');
    const response = FavAPI.createFav(book.id, userId);
    this.setState({inFavs: true});
  };

  render() {
    const { id, cover, title, authors, isbn, publisher, year, size, count, description } = this.state.book;
    const { deleteBook } = this;
    const { inFavs, favCount, date } = this.state;
    return (
      <SiteContainer text>
        <InfoRow>
          {isManager() ? (
            <Link to={{ pathname: `/book/edit/${id}` }}>
              Редактировать
            </Link>
          ) : null}
          {isAdmin() ? (
            <a href="#" onClick={deleteBook}>
              Удалить
            </a>
          ) : null}
        </InfoRow>
        <BookWrapper>
          <Image src={cover} />
          <BookTitle>
            <Title>{title}</Title>
            {authors
              ? authors.map(author => <Author key={author.id}>{author.fullName}</Author>)
              : null}
          </BookTitle>
        </BookWrapper>
        <Divider />
        <BookInfo>
          <InfoRow>
            <RowTitle>ISBN</RowTitle>
            <RowContent>{isbn}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Издатель</RowTitle>
            <RowContent>{publisher ? publisher.name : ''}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Год издания</RowTitle>
            <RowContent>{year}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Количество страниц</RowTitle>
            <RowContent>{size}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Общее количество</RowTitle>
            <RowContent>{count}</RowContent>
          </InfoRow>
          <InfoRow>
            <RowTitle>Количество на складе</RowTitle>
            <RowContent>{count - favCount}</RowContent>
          </InfoRow>
        </BookInfo>
        <Divider />
        <Header size="medium">Описание</Header>
        <p>{description}</p>
        <FavLink inFavs={inFavs} date={date} count={count - favCount} addFav={this.addFav} />
        <p/>
        <p><br/></p>
      </SiteContainer>
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
  margin-top: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const BookInfo = styled.div`
  display: flex;
  flex-direction: column;
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
