import React, {Component} from 'react';
import styled from 'styled-components';
import {Link} from 'react-router-dom';
import {Button} from 'semantic-ui-react';
import Title from './Title';
import Author from './Author';
import FavAPI from '../api/favs';


class BookRow extends Component {
  deleteFav = async () => {
    const {redrawParent} = this.props;
    const userId = localStorage.getItem('userId');
    const response = FavAPI.deleteFav(this.props.book.id, userId).then(() => redrawParent());
  };

  render() {
    const {id, cover, title, authors} = this.props.book;
    const {className} = this.props;
    const {deleteFav} = this;

    return (
      <Wrapper className={className}>
        <Link to={{pathname: `/book/view/${id}`}}>
          <SmallImage src={cover}/>
        </Link>
        <InlinedDiv>
          <Title><Link to={{pathname: `/book/view/${id}`}}>{title}</Link></Title>
          {authors.map(author => (
            <Author key={`${author.id}${author.fullName}`}>{author.fullName}</Author>
          ))}
        </InlinedDiv>

        <Button type="button" style={{backgroundColor: '#d43f3a', color: 'white', marginLeft: 'auto'}}
                onClick={deleteFav}>
          X
        </Button>
      </Wrapper>
    );
  }
}

export default BookRow;

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
`;

const SmallImage = styled.img`
  display: inline-block;
  height: 70px;
  margin-bottom: 8px;
`;

const InlinedDiv = styled.div`
  display: inline-block;
`;
